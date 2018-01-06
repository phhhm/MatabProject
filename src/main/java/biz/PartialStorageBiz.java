package biz;

import biz.dto.PartialStorageDto;
import converter.MainConverter;
import dal.dao.DrugDao;
import dal.dao.DrugDeliveryDao;
import dal.dao.PartialStorageDao;
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
    private PartialStorageDao partialStorageDao;

    @Inject
    private DrugDao drugDao;

    @Inject
    private DrugDeliveryDao drugDeliveryDao;

    @Inject
    private PartialStorageValidator partialStorageValidator;

    @EJB
    private MainConverter converter;

    public List<PartialStorageDto> getAll() throws SQLException, ValidationException {
        List<PartialStorageDto> partialStorageDtoList = converter.getList(partialStorageDao.getAll(), PartialStorageDto.class);
        List<String> validationResult = partialStorageValidator.listDtoValidation(partialStorageDtoList);
        if (validationResult.size() == 0)
            return partialStorageDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PartialStorageDto getById(Long id) throws SQLException, ValidationException {
        PartialStorageDto partialStorageDto = (PartialStorageDto) converter.getObject(partialStorageDao.getById(id), PartialStorageDto.class);
        List<String> validationResult = partialStorageValidator.dtoValidation(partialStorageDto);
        if (validationResult.size()==0)
            return partialStorageDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PartialStorageDto partialStorageDto) throws  SQLException, ValidationException {
        List<String> validationResult = partialStorageValidator.dtoValidation(partialStorageDto);
        if (validationResult.size() == 0) {
            Long drugId = partialStorageDto.getDrugId();
            Long drugDeliveryId = partialStorageDto.getDrugDeliveryId();
            partialStorageDto.setId(null);
            PartialStorageEntity partialStorageEntity = (PartialStorageEntity) converter.getObject(partialStorageDto, PartialStorageEntity.class);
            partialStorageEntity.setDrugDeliveryEntity(drugDeliveryDao.getById(drugDeliveryId));
            partialStorageEntity.setDrugEntity(drugDao.getById(drugId));
            partialStorageDao.Add(partialStorageEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PartialStorageDto partialStorageDto) throws SQLException, ValidationException {
        List<String> validationResult = partialStorageValidator.dtoValidation(partialStorageDto);
        if (validationResult.size() == 0) {
            Long drugDeliveryId = partialStorageDto.getDrugDeliveryId();
            Long drugId = partialStorageDto.getDrugId();
            PartialStorageEntity partialStorageEntity = (PartialStorageEntity) converter.getObject(partialStorageDto, PartialStorageEntity.class);
            partialStorageEntity.setDrugDeliveryEntity(drugDeliveryDao.getById(drugDeliveryId));
            partialStorageEntity.setDrugEntity(drugDao.getById(drugId));
            partialStorageDao.edit(partialStorageEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        partialStorageDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        partialStorageDao.removeAll();
    }
}
