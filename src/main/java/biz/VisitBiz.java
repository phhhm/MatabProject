package biz;

import biz.dto.VisitDto;
import converter.MainConverter;
import dal.dao.EmployeeDao;
import dal.dao.FileDao;
import dal.dao.VisitDao;
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
    private VisitDao visitDao;

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private FileDao fileDao;

    @Inject
    private VisitValidator visitValidator;

    @EJB
    private MainConverter converter;

    public List<VisitDto> getAll() throws SQLException, ValidationException {
        List<VisitDto> visitDtoList = converter.getList(visitDao.getAll(), VisitDto.class);
        List<String> validationResult = visitValidator.listDtoValidation(visitDtoList);
        if (validationResult.size() == 0)
            return visitDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public VisitDto getById(Long id) throws SQLException, ValidationException {
        VisitDto visitDto = (VisitDto) converter.getObject(visitDao.getById(id), VisitDto.class);
        List<String> validationResult = visitValidator.dtoValidation(visitDto);
        if (validationResult.size()==0)
            return visitDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(VisitDto visitDto) throws  SQLException, ValidationException {
        List<String> validationResult = visitValidator.dtoValidation(visitDto);
        if (validationResult.size() == 0) {
            Long fileId = visitDto.getFileId();
            Long employeeId = visitDto.getEmployeeId();
            visitDto.setId(null);
            VisitEntity visitEntity = (VisitEntity) converter.getObject(visitDto, VisitEntity.class);
            visitEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            visitEntity.setFileEntity(fileDao.getById(fileId));
            visitDao.Add(visitEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(VisitDto visitDto) throws SQLException, ValidationException {
        List<String> validationResult = visitValidator.dtoValidation(visitDto);
        if (validationResult.size() == 0) {
            Long fileId = visitDto.getFileId();
            Long employeeId = visitDto.getEmployeeId();
            VisitEntity visitEntity = (VisitEntity) converter.getObject(visitDto, VisitEntity.class);
            visitEntity.setEmployeeEntity(employeeDao.getById(employeeId));
            visitEntity.setFileEntity(fileDao.getById(fileId));
            visitDao.edit(visitEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        visitDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        visitDao.removeAll();
    }
}
