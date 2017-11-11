package biz;

import biz.dto.VisitDto;
import converter.MainConverter;
import dal.dao.EmployeeDaoImp;
import dal.dao.FileDaoImp;
import dal.dao.VisitDaoImp;
import dal.entities.VisitEntity;
import validation.VisitValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class VisitBiz {


    @Inject
    private VisitDaoImp visitDaoImp;

    @Inject
    private EmployeeDaoImp employeeDaoImp;

    @Inject
    private FileDaoImp fileDaoImp;

    @Inject
    private VisitValidator visitValidator;

    @EJB
    private MainConverter converter;

    public List<VisitDto> getAll() throws SQLException, ValidationException {
        List<VisitDto> visitDtoList = converter.getList(visitDaoImp.getAll(), VisitDto.class);
        List<String> validationResult = visitValidator.listDtoValidation(visitDtoList);
        if (validationResult.size() == 0)
            return visitDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public VisitDto getById(Long id) throws SQLException, ValidationException {
        VisitDto visitDto = (VisitDto) converter.getObject(visitDaoImp.getById(id), VisitDto.class);
        List<String> validationResult = visitValidator.dtoValidation(visitDto);
        if (validationResult.size()==0)
            return visitDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(VisitDto visitDto) throws  SQLException, ValidationException {
        Long fileId = visitDto.getFileId();
        Long employeeId = visitDto.getEmployeeId();
        List<String> validationResult = visitValidator.dtoValidation(visitDto);
        if (validationResult.size() == 0) {
            visitDto.setId(null);
            VisitEntity visitEntity = (VisitEntity) converter.getObject(visitDto, VisitEntity.class);
            visitEntity.setEmployeeEntity(employeeDaoImp.getById(employeeId));
            visitEntity.setFileEntity(fileDaoImp.getById(fileId));
            visitDaoImp.Add(visitEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(VisitDto visitDto) throws SQLException, ValidationException {
        Long fileId = visitDto.getFileId();
        Long employeeId = visitDto.getEmployeeId();
        List<String> validationResult = visitValidator.dtoValidation(visitDto);
        if (validationResult.size() == 0) {
            VisitEntity visitEntity = (VisitEntity) converter.getObject(visitDto, VisitEntity.class);
            visitEntity.setEmployeeEntity(employeeDaoImp.getById(employeeId));
            visitEntity.setFileEntity(fileDaoImp.getById(fileId));
            visitDaoImp.edit(visitEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        visitDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        visitDaoImp.removeAll();
    }
}
