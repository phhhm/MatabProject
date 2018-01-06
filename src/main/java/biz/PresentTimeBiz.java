package biz;

import biz.dto.PresentTimeDto;
import converter.MainConverter;
import dal.dao.EmployeeDao;
import dal.dao.PresentTimeDao;
import dal.entities.PresentTimeEntity;
import validation.PresentTimeValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@ApplicationScoped
public class PresentTimeBiz {

    @Inject
    private PresentTimeDao presentTimeDaoImp;

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private PresentTimeValidator presentTimeValidator;

    @EJB
    private MainConverter converter;

    public List<PresentTimeDto> getAll() throws SQLException, ValidationException {
        List<PresentTimeDto> presentTimeDtoList = converter.getList(presentTimeDaoImp.getAll(), PresentTimeDto.class);
        List<String> validationResult = presentTimeValidator.listDtoValidation(presentTimeDtoList);
        if (validationResult.size() == 0)
            return presentTimeDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PresentTimeDto getById(Long id) throws SQLException, ValidationException {
        PresentTimeDto presentTimeDto = (PresentTimeDto) converter.getObject(presentTimeDaoImp.getById(id), PresentTimeDto.class);
        List<String> validationResult = presentTimeValidator.dtoValidation(presentTimeDto);
        if (validationResult.size()==0)
            return presentTimeDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PresentTimeDto presentTimeDto) throws  SQLException, ValidationException {
        List<String> validationResult = presentTimeValidator.dtoValidation(presentTimeDto);
        if (validationResult.size() == 0) {
            Long employeeId = presentTimeDto.getEmployeeId();
            presentTimeDto.setId(null);
            PresentTimeEntity presentTimeEntity = (PresentTimeEntity) converter.getObject(presentTimeDto, PresentTimeEntity.class);
            presentTimeEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            presentTimeDaoImp.Add(presentTimeEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PresentTimeDto presentTimeDto) throws SQLException, ValidationException {
        List<String> validationResult = presentTimeValidator.dtoValidation(presentTimeDto);
        if (validationResult.size() == 0) {
            Long employeeId = presentTimeDto.getEmployeeId();
            PresentTimeEntity presentTimeEntity = (PresentTimeEntity) converter.getObject(presentTimeDto, PresentTimeEntity.class);
            presentTimeEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            presentTimeDaoImp.edit(presentTimeEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        presentTimeDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        presentTimeDaoImp.removeAll();
    }
}
