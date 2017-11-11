package biz;

import biz.dto.PartialStorageDto;
import converter.MainConverter;
import dal.dao.DrugDaoImp;
import dal.dao.DrugDeliveryDaoImp;
import dal.dao.PartialStorageDaoImp;
import dal.entities.PartialStorageEntity;
import validation.PartialStorageValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class PartialStorageBiz {

    @Inject
    private PartialStorageDaoImp partialStorageDaoImp;

    @Inject
    private DrugDaoImp drugDaoImp;

    @Inject
    private DrugDeliveryDaoImp drugDeliveryDaoImp;

    @Inject
    private PartialStorageValidator partialStorageValidator;

    @EJB
    private MainConverter converter;

    public List<PartialStorageDto> getAll() throws SQLException, ValidationException {
        List<PartialStorageDto> partialStorageDtoList = converter.getList(partialStorageDaoImp.getAll(), PartialStorageDto.class);
        List<String> validationResult = partialStorageValidator.listDtoValidation(partialStorageDtoList);
        if (validationResult.size() == 0)
            return partialStorageDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PartialStorageDto getById(Long id) throws SQLException, ValidationException {
        PartialStorageDto partialStorageDto = (PartialStorageDto) converter.getObject(partialStorageDaoImp.getById(id), PartialStorageDto.class);
        List<String> validationResult = partialStorageValidator.dtoValidation(partialStorageDto);
        if (validationResult.size()==0)
            return partialStorageDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PartialStorageDto partialStorageDto) throws  SQLException, ValidationException {
        Long drugId = partialStorageDto.getDrugId();
        Long drugDeliveryId1 = partialStorageDto.getDrugDeliveryId();
        Long drugDeliveryId = partialStorageDto.getDrugDeliveryId();
        List<String> validationResult = partialStorageValidator.dtoValidation(partialStorageDto);
        if (validationResult.size() == 0) {
            partialStorageDto.setId(null);
            PartialStorageEntity partialStorageEntity = (PartialStorageEntity) converter.getObject(partialStorageDto, PartialStorageEntity.class);
            partialStorageEntity.setDrugDeliveryEntity(drugDeliveryDaoImp.getById(drugDeliveryId));
            partialStorageEntity.setDrugEntity(drugDaoImp.getById(drugId));
            partialStorageDaoImp.Add(partialStorageEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PartialStorageDto partialStorageDto) throws SQLException, ValidationException {
        Long drugDeliveryId = partialStorageDto.getDrugDeliveryId();
        Long drugId = partialStorageDto.getDrugId();
        List<String> validationResult = partialStorageValidator.dtoValidation(partialStorageDto);
        if (validationResult.size() == 0) {
            PartialStorageEntity partialStorageEntity = (PartialStorageEntity) converter.getObject(partialStorageDto, PartialStorageEntity.class);
            partialStorageEntity.setDrugDeliveryEntity(drugDeliveryDaoImp.getById(drugDeliveryId));
            partialStorageEntity.setDrugEntity(drugDaoImp.getById(drugId));
            partialStorageDaoImp.edit(partialStorageEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        partialStorageDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        partialStorageDaoImp.removeAll();
    }
}
