package biz;

import biz.dto.PrescriptionDto;
import converter.MainConverter;
import dal.dao.PrescriptionDao;
import dal.dao.VisitDao;
import dal.entities.PrescriptionEntity;
import validation.PrescriptionValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class PrescriptionBiz {


    @Inject
    private PrescriptionDao prescriptionDao;

    @Inject
    private VisitDao visitDao;

    @Inject
    private PrescriptionValidator prescriptionValidator;

    @EJB
    private MainConverter converter;

    public List<PrescriptionDto> getAll() throws SQLException, ValidationException {
        List<PrescriptionDto> prescriptionDtoList = converter.getList(prescriptionDao.getAll(), PrescriptionDto.class);
        List<String> validationResult = prescriptionValidator.listDtoValidation(prescriptionDtoList);
        if (validationResult.size() == 0)
            return prescriptionDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PrescriptionDto getById(Long id) throws SQLException, ValidationException {
        PrescriptionDto prescriptionDto = (PrescriptionDto) converter.getObject(prescriptionDao.getById(id), PrescriptionDto.class);
        List<String> validationResult = prescriptionValidator.dtoValidation(prescriptionDto);
        if (validationResult.size()==0)
            return prescriptionDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PrescriptionDto prescriptionDto) throws  SQLException, ValidationException {
        List<String> validationResult = prescriptionValidator.dtoValidation(prescriptionDto);
        if (validationResult.size() == 0) {
            Long visitId = prescriptionDto.getVisitId();
            prescriptionDto.setId(null);
            PrescriptionEntity prescriptionEntity = (PrescriptionEntity) converter.getObject(prescriptionDto, PrescriptionEntity.class);
            prescriptionEntity.setVisitEntity(visitDao.getById(visitId));
            prescriptionDao.Add(prescriptionEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PrescriptionDto prescriptionDto) throws SQLException, ValidationException {
        List<String> validationResult = prescriptionValidator.dtoValidation(prescriptionDto);
        if (validationResult.size() == 0) {
            Long visitId = prescriptionDto.getVisitId();
            PrescriptionEntity prescriptionEntity = (PrescriptionEntity) converter.getObject(prescriptionDto, PrescriptionEntity.class);
            prescriptionEntity.setVisitEntity(visitDao.getById(visitId));
            prescriptionDao.edit(prescriptionEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        prescriptionDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        prescriptionDao.removeAll();
    }
}
