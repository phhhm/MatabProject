package biz;

import biz.dto.DrugDto;
import converter.MainConverter;
import dal.dao.DrugDao;
import dal.entities.DrugEntity;
import validation.DrugValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class DrugBiz {

    @Inject
    private DrugDao drugDao;

    @Inject
    private DrugValidator drugValidator;

    @EJB
    private MainConverter converter;

    public List<DrugDto> getAll() throws SQLException, ValidationException {
        List<DrugDto> drugDtoList = converter.getList(drugDao.getAll(), DrugDto.class);
        List<String> validationResult = drugValidator.listDtoValidation(drugDtoList);
        if (validationResult.size() == 0)
            return drugDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public DrugDto getById(Long id) throws SQLException, ValidationException {
        DrugDto drugDto = (DrugDto) converter.getObject(drugDao.getById(id), DrugDto.class);
        List<String> validationResult = drugValidator.dtoValidation(drugDto);
        if (validationResult.size()==0)
            return drugDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(DrugDto drugDto) throws  SQLException, ValidationException {
        List<String> validationResult = drugValidator.dtoValidation(drugDto);
        if (validationResult.size() == 0) {
            drugDto.setId(null);
            DrugEntity drugEntity = (DrugEntity) converter.getObject(drugDto, DrugEntity.class);
            drugDao.Add(drugEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(DrugDto drugDto) throws SQLException, ValidationException {
        List<String> validationResult = drugValidator.dtoValidation(drugDto);
        if (validationResult.size() == 0) {
            DrugEntity drugEntity = (DrugEntity) converter.getObject(drugDto, DrugEntity.class);
            drugDao.edit(drugEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        drugDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        drugDao.removeAll();
    }
}
