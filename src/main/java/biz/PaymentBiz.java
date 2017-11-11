package biz;

import biz.dto.PaymentDto;
import converter.MainConverter;
import dal.dao.EmployeeDaoImp;
import dal.dao.PaymentDaoImp;
import dal.entities.PaymentEntity;
import validation.PaymentValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
public class PaymentBiz {

    @Inject
    private PaymentDaoImp paymentDaoImp;

    @Inject
    private EmployeeDaoImp employeeDaoImp;

    @Inject
    private PaymentValidator paymentValidator;

    @EJB
    private MainConverter converter;

    public List<PaymentDto> getAll() throws SQLException, ValidationException {
        List<PaymentDto> paymentDtoList = converter.getList(paymentDaoImp.getAll(), PaymentDto.class);
        List<String> validationResult = paymentValidator.listDtoValidation(paymentDtoList);
        if (validationResult.size() == 0)
            return paymentDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PaymentDto getById(Long id) throws SQLException, ValidationException {
        PaymentDto paymentDto = (PaymentDto) converter.getObject(paymentDaoImp.getById(id), PaymentDto.class);
        List<String> validationResult = paymentValidator.dtoValidation(paymentDto);
        if (validationResult.size()==0)
            return paymentDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PaymentDto paymentDto) throws  SQLException, ValidationException {
        Long employeeId = paymentDto.getEmployeeId();
        List<String> validationResult = paymentValidator.dtoValidation(paymentDto);
        if (validationResult.size() == 0) {
            paymentDto.setId(null);
            PaymentEntity paymentEntity = (PaymentEntity) converter.getObject(paymentDto, PaymentEntity.class);
            paymentEntity.setEmployeeEntity(employeeDaoImp.getById(employeeId));
            paymentDaoImp.Add(paymentEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PaymentDto paymentDto) throws SQLException, ValidationException {
        Long employeeId = paymentDto.getEmployeeId();
        List<String> validationResult = paymentValidator.dtoValidation(paymentDto);
        if (validationResult.size() == 0) {
            PaymentEntity paymentEntity = (PaymentEntity) converter.getObject(paymentDto, PaymentEntity.class);
            paymentEntity.setEmployeeEntity(employeeDaoImp.getById(employeeId));
            paymentDaoImp.edit(paymentEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        paymentDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        paymentDaoImp.removeAll();
    }
}
