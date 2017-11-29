package biz;

import biz.dto.MainStorageDto;
import converter.MainConverter;
import dal.dao.DrugDaoImp;
import dal.dao.DrugDeliveryDaoImp;
import dal.dao.MainStorageDaoImp;
import dal.entities.MainStorageEntity;
import validation.MainStorageValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class MainStorageBiz {

    @Inject
    private MainStorageDaoImp mainStorageDaoImp;

    @Inject
    private DrugDaoImp drugDaoImp;

    @Inject
    private DrugDeliveryDaoImp drugDeliveryDaoImp;

    @Inject
    private MainStorageValidator mainStorageValidator;

    @EJB
    private MainConverter converter;

    public List<MainStorageDto> getAll() throws SQLException, ValidationException {
        List<MainStorageDto> mainStorageDtoList = converter.getList(mainStorageDaoImp.getAll(), MainStorageDto.class);
        List<String> validationResult = mainStorageValidator.listDtoValidation(mainStorageDtoList);
        if (validationResult.size() == 0)
            return mainStorageDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public MainStorageDto getById(Long id) throws SQLException, ValidationException {
        MainStorageDto mainStorageDto = (MainStorageDto) converter.getObject(mainStorageDaoImp.getById(id), MainStorageDto.class);
        List<String> validationResult = mainStorageValidator.dtoValidation(mainStorageDto);
        if (validationResult.size()==0)
            return mainStorageDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(MainStorageDto mainStorageDto) throws  SQLException, ValidationException {
        List<String> validationResult = mainStorageValidator.dtoValidation(mainStorageDto);
        if (validationResult.size() == 0) {
            Long drugId = mainStorageDto.getDrugId();
            Long drugDeliveryId = mainStorageDto.getDrugDeliveryId();
            mainStorageDto.setId(null);
            MainStorageEntity mainStorageEntity = (MainStorageEntity) converter.getObject(mainStorageDto, MainStorageEntity.class);
            mainStorageEntity.setDrugDeliveryEntity(drugDeliveryDaoImp.getById(drugDeliveryId));
            mainStorageEntity.setDrugEntity(drugDaoImp.getById(drugId));
            mainStorageDaoImp.Add(mainStorageEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(MainStorageDto mainStorageDto) throws SQLException, ValidationException {
        List<String> validationResult = mainStorageValidator.dtoValidation(mainStorageDto);
        if (validationResult.size() == 0) {
            Long drugId = mainStorageDto.getDrugId();
            Long drugDeliveryId = mainStorageDto.getDrugDeliveryId();
            MainStorageEntity mainStorageEntity = (MainStorageEntity) converter.getObject(mainStorageDto, MainStorageEntity.class);
            mainStorageEntity.setDrugDeliveryEntity(drugDeliveryDaoImp.getById(drugDeliveryId));
            mainStorageEntity.setDrugEntity(drugDaoImp.getById(drugId));
            mainStorageDaoImp.edit(mainStorageEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        mainStorageDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        mainStorageDaoImp.removeAll();
    }
}
