package biz;

import biz.dto.TransactionDto;
import converter.MainConverter;
import dal.dao.PaymentDao;
import dal.dao.TransactionDao;
import dal.entities.TransactionEntity;
import validation.TransactionValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
public class TransactionBiz {


    @Inject
    private TransactionDao transactionDao;

    @Inject
    private PaymentDao paymentDao;

    @Inject
    private TransactionValidator transactionValidator;

    @EJB
    private MainConverter converter;

    public List<TransactionDto> getAll() throws SQLException, ValidationException {
        List<TransactionDto> transactionDtoList = converter.getList(transactionDao.getAll(), TransactionDto.class);
        List<String> validationResult = transactionValidator.listDtoValidation(transactionDtoList);
        if (validationResult.size() == 0)
            return transactionDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public TransactionDto getById(Long id) throws SQLException, ValidationException {
        TransactionDto transactionDto = (TransactionDto) converter.getObject(transactionDao.getById(id), TransactionDto.class);
        List<String> validationResult = transactionValidator.dtoValidation(transactionDto);
        if (validationResult.size()==0)
            return transactionDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(TransactionDto transactionDto) throws  SQLException, ValidationException {
        List<String> validationResult = transactionValidator.dtoValidation(transactionDto);
        if (validationResult.size() == 0) {
            Long paymentId = transactionDto.getPaymentId();
            transactionDto.setId(null);
            TransactionEntity transactionEntity = (TransactionEntity) converter.getObject(transactionDto, TransactionEntity.class);
            transactionEntity.setPaymentEntity(paymentDao.getById(paymentId));
            transactionDao.Add(transactionEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(TransactionDto transactionDto) throws SQLException, ValidationException {
        List<String> validationResult = transactionValidator.dtoValidation(transactionDto);
        if (validationResult.size() == 0) {
            Long paymentId = transactionDto.getPaymentId();
            TransactionEntity transactionEntity = (TransactionEntity) converter.getObject(transactionDto, TransactionEntity.class);
            transactionEntity.setPaymentEntity(paymentDao.getById(paymentId));
            transactionDao.edit(transactionEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        transactionDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        transactionDao.removeAll();
    }
}
