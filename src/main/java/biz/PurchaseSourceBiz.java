package biz;

import biz.dto.PurchaseSourceDto;
import converter.MainConverter;
import dal.dao.PurchaseSourceDaoImp;
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
    private PurchaseSourceDaoImp purchaseSourceDaoImp;

    @Inject
    private PurchaseSourceValidator purchaseSourceValidator;

    @EJB
    private MainConverter converter;

    public List<PurchaseSourceDto> getAll() throws SQLException, ValidationException {
        List<PurchaseSourceDto> purchaseSourceDtoList = converter.getList(purchaseSourceDaoImp.getAll(), PurchaseSourceDto.class);
        List<String> validationResult = purchaseSourceValidator.listDtoValidation(purchaseSourceDtoList);
        if (validationResult.size() == 0)
            return purchaseSourceDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PurchaseSourceDto getById(Long id) throws SQLException, ValidationException {
        PurchaseSourceDto purchaseSourceDto = (PurchaseSourceDto) converter.getObject(purchaseSourceDaoImp.getById(id), PurchaseSourceDto.class);
        List<String> validationResult = purchaseSourceValidator.dtoValidation(purchaseSourceDto);
        if (validationResult.size()==0)
            return purchaseSourceDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PurchaseSourceDto purchaseSourceDto) throws  SQLException, ValidationException {
        List<String> validationResult = purchaseSourceValidator.dtoValidation(purchaseSourceDto);
        if (validationResult.size() == 0) {
            purchaseSourceDto.setId(null);
            PurchaseSourceEntity purchaseSourceEntity = (PurchaseSourceEntity) converter.getObject(purchaseSourceDto, PurchaseSourceEntity.class);
            purchaseSourceDaoImp.Add(purchaseSourceEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PurchaseSourceDto purchaseSourceDto) throws SQLException, ValidationException {
        List<String> validationResult = purchaseSourceValidator.dtoValidation(purchaseSourceDto);
        if (validationResult.size() == 0) {
            PurchaseSourceEntity purchaseSourceEntity = (PurchaseSourceEntity) converter.getObject(purchaseSourceDto, PurchaseSourceEntity.class);
            purchaseSourceDaoImp.edit(purchaseSourceEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        purchaseSourceDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        purchaseSourceDaoImp.removeAll();
    }
}
