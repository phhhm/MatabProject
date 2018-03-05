package biz;

import biz.dto.ContractDto;
import biz.dto.DrugDeliveryDto;
import biz.dto.TransactionDto;
import converter.MainConverter;
import dal.dao.DrugDeliveryDao;
import dal.dao.EmployeeDao;
import dal.dao.TransactionDao;
import dal.entities.DrugDeliveryEntity;
import validation.DrugDeliveryValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DrugDeliveryBiz {

    @Inject
    private DrugDeliveryDao drugDeliveryDao;

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private TransactionDao transactionDao;

    @Inject
    private DrugDeliveryValidator drugDeliveryValidator;

    @Inject
    private TransactionBiz transactionBiz;

    @EJB
    private MainConverter converter;

    public List<DrugDeliveryDto> getAll() throws SQLException, ValidationException {
        List<DrugDeliveryDto> drugDeliveryDtoList = converter.getList(drugDeliveryDao.getAll(), DrugDeliveryDto.class);
        List<String> validationResult = drugDeliveryValidator.listDtoValidation(drugDeliveryDtoList);
        if (validationResult.size() == 0)
            return drugDeliveryDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public DrugDeliveryDto getById(Long id) throws SQLException, ValidationException {
        DrugDeliveryDto drugDeliveryDto = (DrugDeliveryDto) converter.getObject(drugDeliveryDao.getById(id), DrugDeliveryDto.class);
        List<String> validationResult = drugDeliveryValidator.dtoValidation(drugDeliveryDto);
        if (validationResult.size()==0)
            return drugDeliveryDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(DrugDeliveryDto drugDeliveryDto) throws  SQLException, ValidationException {
        List<String> validationResult = drugDeliveryValidator.dtoValidation(drugDeliveryDto);
        if (validationResult.size() == 0) {
            Long employeeId = drugDeliveryDto.getEmployeeId();
            Long transactionId = drugDeliveryDto.getTransactionId();
            drugDeliveryDto.setId(null);
            DrugDeliveryEntity drugDeliveryEntity = (DrugDeliveryEntity) converter.getObject(drugDeliveryDto, DrugDeliveryEntity.class);
            drugDeliveryEntity.setTransactionEntity(transactionDao.getById(transactionId));
            drugDeliveryEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            drugDeliveryDao.Add(drugDeliveryEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(DrugDeliveryDto drugDeliveryDto) throws SQLException, ValidationException {
        List<String> validationResult = drugDeliveryValidator.dtoValidation(drugDeliveryDto);
        if (validationResult.size() == 0) {
            Long transactionId = drugDeliveryDto.getTransactionId();
            Long employeeId = drugDeliveryDto.getEmployeeId();
            DrugDeliveryEntity drugDeliveryEntity = (DrugDeliveryEntity) converter.getObject(drugDeliveryDto, DrugDeliveryEntity.class);
            drugDeliveryEntity.setTransactionEntity(transactionDao.getById(transactionId));
            drugDeliveryEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            drugDeliveryDao.edit(drugDeliveryEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        drugDeliveryDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        drugDeliveryDao.removeAll();
    }

    public List<TransactionDto> getTransactionWithNoDuplicate() throws SQLException, ValidationException {
        List<TransactionDto> temp = new ArrayList<>();
        List<DrugDeliveryDto> allDrugDeliveryDtoList = getAll();
        List<TransactionDto> transactionDtoList = transactionBiz.getAll();

        for (DrugDeliveryDto drugDeliveryDto : allDrugDeliveryDtoList) {
            for (TransactionDto transactionDto : transactionDtoList) {
                if ((drugDeliveryDto.getTransactionId()) == (transactionDto.getId())){
                    temp.add(transactionDto);
                }
            }
        }
        transactionDtoList.removeIf(temp::contains);

        return transactionDtoList;
    }
}
