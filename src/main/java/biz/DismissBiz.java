package biz;

import biz.dto.DismissDto;
import converter.MainConverter;
import dal.dao.DismissDao;
import dal.dao.EmployeeDao;
import dal.entities.DismissEntity;
import validation.DismissValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
public class DismissBiz {

    @Inject
    private DismissDao dismissDao;

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private DismissValidator dismissValidator;

    @EJB
    private MainConverter converter;

    public List<DismissDto> getAll() throws SQLException, ValidationException {
        List<DismissDto> dismissDtoList = converter.getList(dismissDao.getAll(), DismissDto.class);
        List<String> validationResult = dismissValidator.listDtoValidation(dismissDtoList);
        if (validationResult.size() == 0)
            return dismissDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public DismissDto getById(Long id) throws SQLException, ValidationException {
        DismissDto dismissDto = (DismissDto) converter.getObject(dismissDao.getById(id), DismissDto.class);
        List<String> validationResult = dismissValidator.dtoValidation(dismissDto);
        if (validationResult.size()==0)
            return dismissDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(DismissDto dismissDto) throws  SQLException, ValidationException {
        List<String> validationResult = dismissValidator.dtoValidation(dismissDto);
        if (validationResult.size() == 0) {
            Long employeeId = dismissDto.getEmployeeId();
            dismissDto.setId(null);
            DismissEntity dismissEntity = (DismissEntity) converter.getObject(dismissDto, DismissEntity.class);
            dismissEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            dismissDao.Add(dismissEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(DismissDto dismissDto) throws SQLException, ValidationException {
        List<String> validationResult = dismissValidator.dtoValidation(dismissDto);
        if (validationResult.size() == 0) {
            Long employeeId = dismissDto.getEmployeeId();
            DismissEntity dismissEntity = (DismissEntity) converter.getObject(dismissDto, DismissEntity.class);
            dismissEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            dismissDao.edit(dismissEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        dismissDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        dismissDao.removeAll();
    }
}
