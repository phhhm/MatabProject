package biz;

import biz.dto.PaymentDto;
import converter.MainConverter;
import dal.dao.EmployeeDao;
import dal.dao.PaymentDao;
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
    private PaymentDao paymentDao;

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private PaymentValidator paymentValidator;

    @EJB
    private MainConverter converter;

    public List<PaymentDto> getAll() throws SQLException, ValidationException {
        List<PaymentDto> paymentDtoList = converter.getList(paymentDao.getAll(), PaymentDto.class);
        List<String> validationResult = paymentValidator.listDtoValidation(paymentDtoList);
        if (validationResult.size() == 0)
            return paymentDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PaymentDto getById(Long id) throws SQLException, ValidationException {
        PaymentDto paymentDto = (PaymentDto) converter.getObject(paymentDao.getById(id), PaymentDto.class);
        List<String> validationResult = paymentValidator.dtoValidation(paymentDto);
        if (validationResult.size()==0)
            return paymentDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PaymentDto paymentDto) throws  SQLException, ValidationException {
        List<String> validationResult = paymentValidator.dtoValidation(paymentDto);
        if (validationResult.size() == 0) {
            Long employeeId = paymentDto.getEmployeeId();
            paymentDto.setId(null);
            PaymentEntity paymentEntity = (PaymentEntity) converter.getObject(paymentDto, PaymentEntity.class);
            paymentEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            paymentDao.Add(paymentEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PaymentDto paymentDto) throws SQLException, ValidationException {
        List<String> validationResult = paymentValidator.dtoValidation(paymentDto);
        if (validationResult.size() == 0) {
            Long employeeId = paymentDto.getEmployeeId();
            PaymentEntity paymentEntity = (PaymentEntity) converter.getObject(paymentDto, PaymentEntity.class);
            paymentEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            paymentDao.edit(paymentEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        paymentDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        paymentDao.removeAll();
    }
}
