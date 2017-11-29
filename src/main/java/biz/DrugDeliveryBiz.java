package biz;

import biz.dto.DrugDeliveryDto;
import converter.MainConverter;
import dal.dao.DrugDeliveryDaoImp;
import dal.dao.EmployeeDaoImp;
import dal.dao.TransactionDaoImp;
import dal.entities.DrugDeliveryEntity;
import validation.DrugDeliveryValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class DrugDeliveryBiz {

    @Inject
    private DrugDeliveryDaoImp drugDeliveryDaoImp;

    @Inject
    private EmployeeDaoImp employeeDaoImp;

    @Inject
    private TransactionDaoImp transactionDaoImp;

    @Inject
    private DrugDeliveryValidator drugDeliveryValidator;

    @EJB
    private MainConverter converter;

    public List<DrugDeliveryDto> getAll() throws SQLException, ValidationException {
        List<DrugDeliveryDto> drugDeliveryDtoList = converter.getList(drugDeliveryDaoImp.getAll(), DrugDeliveryDto.class);
        List<String> validationResult = drugDeliveryValidator.listDtoValidation(drugDeliveryDtoList);
        if (validationResult.size() == 0)
            return drugDeliveryDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public DrugDeliveryDto getById(Long id) throws SQLException, ValidationException {
        DrugDeliveryDto drugDeliveryDto = (DrugDeliveryDto) converter.getObject(drugDeliveryDaoImp.getById(id), DrugDeliveryDto.class);
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
            drugDeliveryEntity.setTransactionEntity(transactionDaoImp.getById(transactionId));
            drugDeliveryEntity.setEmployeeEntity(employeeDaoImp.getById(employeeId));
            drugDeliveryDaoImp.Add(drugDeliveryEntity);
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
            drugDeliveryEntity.setTransactionEntity(transactionDaoImp.getById(transactionId));
            drugDeliveryEntity.setEmployeeEntity(employeeDaoImp.getById(employeeId));
            drugDeliveryDaoImp.edit(drugDeliveryEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        drugDeliveryDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        drugDeliveryDaoImp.removeAll();
    }
}
