package biz;

import biz.dto.MainStorageDto;
import converter.MainConverter;
import dal.dao.DrugDao;
import dal.dao.DrugDeliveryDao;
import dal.dao.MainStorageDao;
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
    private MainStorageDao mainStorageDao;

    @Inject
    private DrugDao drugDao;

    @Inject
    private DrugDeliveryDao drugDeliveryDao;

    @Inject
    private MainStorageValidator mainStorageValidator;

    @EJB
    private MainConverter converter;

    public List<MainStorageDto> getAll() throws SQLException, ValidationException {
        List<MainStorageDto> mainStorageDtoList = converter.getList(mainStorageDao.getAll(), MainStorageDto.class);
        List<String> validationResult = mainStorageValidator.listDtoValidation(mainStorageDtoList);
        if (validationResult.size() == 0)
            return mainStorageDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public MainStorageDto getById(Long id) throws SQLException, ValidationException {
        MainStorageDto mainStorageDto = (MainStorageDto) converter.getObject(mainStorageDao.getById(id), MainStorageDto.class);
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
            mainStorageEntity.setDrugDeliveryEntity(drugDeliveryDao.getById(drugDeliveryId));
            mainStorageEntity.setDrugEntity(drugDao.getById(drugId));
            mainStorageDao.Add(mainStorageEntity);
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
            mainStorageEntity.setDrugDeliveryEntity(drugDeliveryDao.getById(drugDeliveryId));
            mainStorageEntity.setDrugEntity(drugDao.getById(drugId));
            mainStorageDao.edit(mainStorageEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        mainStorageDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        mainStorageDao.removeAll();
    }
}
