package biz;

import biz.dto.ContractDto;
import biz.dto.EmployeeDto;
import converter.MainConverter;
import dal.dao.ContractDao;
import dal.dao.EmployeeDao;
import dal.entities.ContractEntity;
import validation.ContractValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
public class ContractBiz {

    @Inject
    private ContractDao contractDao;

    @Inject
    private EmployeeBiz employeeBiz;

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private ContractValidator contractValidator;

    @EJB
    private MainConverter converter;

    public List<ContractDto> getAll() throws SQLException, ValidationException {
        List<ContractDto> contractDtoList = converter.getList(contractDao.getAll(), ContractDto.class);
        List<String> validationResult = contractValidator.listDtoValidation(contractDtoList);
        if (validationResult.size() == 0)
            return contractDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public ContractDto getById(Long id) throws SQLException, ValidationException {
        ContractDto contractDto = (ContractDto) converter.getObject(contractDao.getById(id), ContractDto.class);
        List<String> validationResult = contractValidator.dtoValidation(contractDto);
        if (validationResult.size()==0)
            return contractDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(ContractDto contractDto) throws  SQLException, ValidationException {
        List<String> validationResult = contractValidator.dtoValidation(contractDto);
        if (validationResult.size() == 0) {
            Long employeeId = contractDto.getEmployeeId();
            contractDto.setId(null);
            ContractEntity contractEntity = (ContractEntity) converter.getObject(contractDto, ContractEntity.class);
            contractEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            contractDao.Add(contractEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(ContractDto contractDto) throws SQLException, ValidationException {
        List<String> validationResult = contractValidator.dtoValidation(contractDto);
        if (validationResult.size() == 0) {
            Long employeeId = contractDto.getEmployeeId();
            ContractEntity contractEntity = (ContractEntity) converter.getObject(contractDto, ContractEntity.class);
            contractEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            contractDao.edit(contractEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        contractDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        contractDao.removeAll();
    }

    public List<EmployeeDto> getEmployeeWithNoDuplicate() throws SQLException, ValidationException {
        List<EmployeeDto> noDuplicateEmployeeDtoList = new ArrayList<EmployeeDto>();
        List<EmployeeDto> temp = new ArrayList<EmployeeDto>();
        List<ContractDto> allContractDtoList = getAll();
        List<EmployeeDto> employeeDtoList = employeeBiz.getAll();
        List<Long> employeeId = new ArrayList<Long>();

        for (ContractDto contractDto : allContractDtoList) {
            for (EmployeeDto employeeDto : employeeDtoList) {
                if ((contractDto.getEmployeeId()) == (employeeDto.getId())){
                    temp.add(employeeDto);
                }
            }
        }
        employeeDtoList.removeIf(temp::contains);

        return employeeDtoList;
    }
}
