package biz;

import biz.dto.EmployeeDto;
import converter.MainConverter;
import dal.dao.EmployeeDao;
import dal.entities.EmployeeEntity;
import validation.EmployeeValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 26/10/2017.
 */
@ApplicationScoped
public class EmployeeBiz {

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private EmployeeValidator employeeValidator;

    @EJB
    private MainConverter converter;

    public List<EmployeeDto> getAll() throws SQLException, ValidationException {
        List<EmployeeDto> employeeDtoList = converter.getList(employeeDao.getAll(), EmployeeDto.class);
        List<String> validationResult = employeeValidator.listDtoValidation(employeeDtoList);
        if (validationResult.size() == 0)
            return employeeDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public EmployeeDto getById(Long id) throws SQLException, ValidationException {
        EmployeeDto employeeDto = (EmployeeDto) converter.getObject(employeeDao.getById(id), EmployeeDto.class);
        List<String> validationResult = employeeValidator.dtoValidation(employeeDto);
        if (validationResult.size()==0)
            return employeeDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(EmployeeDto employeeDto) throws  SQLException, ValidationException {
        List<String> validationResult = employeeValidator.dtoValidation(employeeDto);
        if (validationResult.size() == 0) {
            employeeDto.setId(null);
            EmployeeEntity employeeEntity = (EmployeeEntity) converter.getObject(employeeDto, EmployeeEntity.class);
            employeeDao.Add(employeeEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(EmployeeDto employeeDto) throws SQLException, ValidationException {
        List<String> validationResult = employeeValidator.dtoValidation(employeeDto);
        if (validationResult.size() == 0) {
            EmployeeEntity employeeEntity = (EmployeeEntity) converter.getObject(employeeDto, EmployeeEntity.class);
            employeeDao.edit(employeeEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        employeeDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        employeeDao.removeAll();
    }
}
