package biz;

import biz.dto.ContractDto;
import converter.MainConverter;
import dal.dao.ContractDaoImp;
import dal.dao.EmployeeDaoImp;
import dal.entities.ContractEntity;
import dal.entities.EmployeeEntity;
import validation.ContractValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
public class ContractBiz {

    @Inject
    private ContractDaoImp contractDaoImp;

    @Inject
    private EmployeeDaoImp employeeDaoImp;

    @Inject
    private ContractValidator contractValidator;

    @EJB
    private MainConverter converter;

    public List<ContractDto> getAll() throws SQLException, ValidationException {
        List<ContractDto> contractDtoList = converter.getList(contractDaoImp.getAll(), ContractDto.class);
        List<String> validationResult = contractValidator.listDtoValidation(contractDtoList);
        if (validationResult.size() == 0)
            return contractDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public ContractDto getById(Long id) throws SQLException, ValidationException {
        ContractDto contractDto = (ContractDto) converter.getObject(contractDaoImp.getById(id), ContractDto.class);
        List<String> validationResult = contractValidator.dtoValidation(contractDto);
        if (validationResult.size()==0)
            return contractDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(ContractDto contractDto) throws  SQLException, ValidationException {
        Long employeeId = contractDto.getEmployeeId();
        List<String> validationResult = contractValidator.dtoValidation(contractDto);
        if (validationResult.size() == 0) {
            contractDto.setId(null);
            ContractEntity contractEntity = (ContractEntity) converter.getObject(contractDto, ContractEntity.class);
            contractEntity.setEmployeeEntity(employeeDaoImp.getById(employeeId));
            contractDaoImp.Add(contractEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(ContractDto contractDto) throws SQLException, ValidationException {
        Long employeeId = contractDto.getEmployeeId();
        List<String> validationResult = contractValidator.dtoValidation(contractDto);
        if (validationResult.size() == 0) {
            ContractEntity contractEntity = (ContractEntity) converter.getObject(contractDto, ContractEntity.class);
            contractEntity.setEmployeeEntity(employeeDaoImp.getById(employeeId));
            contractDaoImp.edit(contractEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        contractDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        contractDaoImp.removeAll();
    }
}
