package biz;

import biz.dto.GiftDto;
import converter.MainConverter;
import dal.dao.GiftDao;
import dal.dao.PaymentDao;
import dal.entities.GiftEntity;
import validation.GiftValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
public class GiftBiz {

    @Inject
    private GiftDao giftDao;

    @Inject
    private PaymentDao paymentDao;

    @Inject
    private GiftValidator giftValidator;

    @EJB
    private MainConverter converter;

    public List<GiftDto> getAll() throws SQLException, ValidationException {
        List<GiftDto> giftDtoList = converter.getList(giftDao.getAll(), GiftDto.class);
        List<String> validationResult = giftValidator.listDtoValidation(giftDtoList);
        if (validationResult.size() == 0)
            return giftDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public GiftDto getById(Long id) throws SQLException, ValidationException {
        GiftDto giftDto = (GiftDto) converter.getObject(giftDao.getById(id), GiftDto.class);
        List<String> validationResult = giftValidator.dtoValidation(giftDto);
        if (validationResult.size()==0)
            return giftDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(GiftDto giftDto) throws  SQLException, ValidationException {
        List<String> validationResult = giftValidator.dtoValidation(giftDto);
        if (validationResult.size() == 0) {
            Long paymentId = giftDto.getPaymentId();
            giftDto.setId(null);
            GiftEntity giftEntity = (GiftEntity) converter.getObject(giftDto, GiftEntity.class);
            giftEntity.setPaymentEntity(paymentDao.getById(paymentId));
            giftDao.Add(giftEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(GiftDto giftDto) throws SQLException, ValidationException {
        List<String> validationResult = giftValidator.dtoValidation(giftDto);
        if (validationResult.size() == 0) {
            Long paymentId = giftDto.getPaymentId();
            GiftEntity giftEntity = (GiftEntity) converter.getObject(giftDto, GiftEntity.class);
            giftEntity.setPaymentEntity(paymentDao.getById(paymentId));
            giftDao.edit(giftEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        giftDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        giftDao.removeAll();
    }
}
