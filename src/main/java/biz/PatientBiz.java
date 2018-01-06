package biz;

import biz.dto.PatientDto;
import converter.MainConverter;
import dal.dao.PatientDao;
import dal.entities.PatientEntity;
import validation.PatientValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 10/28/2017.
 */
@ApplicationScoped
public class PatientBiz {

    @Inject
    private PatientDao patientDao;

    @Inject
    private PatientValidator patientValidator;

    @EJB
    private MainConverter converter;

    public List<PatientDto> getAll() throws SQLException, ValidationException {
        List<PatientDto> patientDtoList = converter.getList(patientDao.getAll(), PatientDto.class);
        List<String> validationResult = patientValidator.listDtoValidation(patientDtoList);
        if (validationResult.size() == 0)
            return patientDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PatientDto getById(Long id) throws SQLException, ValidationException {
        PatientDto patientDto = (PatientDto) converter.getObject(patientDao.getById(id), PatientDto.class);
        List<String> validationResult = patientValidator.dtoValidation(patientDto);
        if (validationResult.size()==0)
            return patientDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PatientDto patientDto) throws  SQLException, ValidationException {
        List<String> validationResult = patientValidator.dtoValidation(patientDto);
        if (validationResult.size() == 0) {
            patientDto.setId(null);
            PatientEntity patientEntity = (PatientEntity) converter.getObject(patientDto, PatientEntity.class);
            patientDao.Add(patientEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PatientDto patientDto) throws SQLException, ValidationException {
        List<String> validationResult = patientValidator.dtoValidation(patientDto);
        if (validationResult.size() == 0) {
            PatientEntity patientEntity = (PatientEntity) converter.getObject(patientDto, PatientEntity.class);
            patientDao.edit(patientEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        patientDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        patientDao.removeAll();
    }
}
