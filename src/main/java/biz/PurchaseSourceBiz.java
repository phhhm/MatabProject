package biz;

import biz.dto.PurchaseSourceDto;
import converter.MainConverter;
import dal.dao.PurchaseSourceDao;
import dal.entities.PurchaseSourceEntity;
import validation.PurchaseSourceValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class PurchaseSourceBiz {

    @Inject
    private PurchaseSourceDao purchaseSourceDao;

    @Inject
    private PurchaseSourceValidator purchaseSourceValidator;

    @EJB
    private MainConverter converter;

    public List<PurchaseSourceDto> getAll() throws SQLException, ValidationException {
        List<PurchaseSourceDto> purchaseSourceDtoList = converter.getList(purchaseSourceDao.getAll(), PurchaseSourceDto.class);
        List<String> validationResult = purchaseSourceValidator.listDtoValidation(purchaseSourceDtoList);
        if (validationResult.size() == 0)
            return purchaseSourceDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PurchaseSourceDto getById(Long id) throws SQLException, ValidationException {
        PurchaseSourceDto purchaseSourceDto = (PurchaseSourceDto) converter.getObject(purchaseSourceDao.getById(id), PurchaseSourceDto.class);
        List<String> validationResult = purchaseSourceValidator.dtoValidation(purchaseSourceDto);
        if (validationResult.size()==0)
            return purchaseSourceDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PurchaseSourceDto purchaseSourceDto) throws SQLException, ValidationException {
        List<String> validationResult = purchaseSourceValidator.dtoValidation(purchaseSourceDto);
        if (validationResult.size() == 0) {
            purchaseSourceDto.setId(null);
            PurchaseSourceEntity purchaseSourceEntity = (PurchaseSourceEntity) converter.getObject(purchaseSourceDto, PurchaseSourceEntity.class);
            purchaseSourceDao.Add(purchaseSourceEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PurchaseSourceDto purchaseSourceDto) throws SQLException, ValidationException {
        List<String> validationResult = purchaseSourceValidator.dtoValidation(purchaseSourceDto);
        if (validationResult.size() == 0) {
            PurchaseSourceEntity purchaseSourceEntity = (PurchaseSourceEntity) converter.getObject(purchaseSourceDto, PurchaseSourceEntity.class);
            purchaseSourceDao.edit(purchaseSourceEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        purchaseSourceDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        purchaseSourceDao.removeAll();
    }
}
