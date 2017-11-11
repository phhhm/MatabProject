package biz;

import biz.dto.PrescriptionDto;
import converter.MainConverter;
import dal.dao.PrescriptionDaoImp;
import dal.dao.VisitDaoImp;
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
    private PrescriptionDaoImp prescriptionDaoImp;

    @Inject
    private VisitDaoImp visitDaoImp;

    @Inject
    private PrescriptionValidator prescriptionValidator;

    @EJB
    private MainConverter converter;

    public List<PrescriptionDto> getAll() throws SQLException, ValidationException {
        List<PrescriptionDto> prescriptionDtoList = converter.getList(prescriptionDaoImp.getAll(), PrescriptionDto.class);
        List<String> validationResult = prescriptionValidator.listDtoValidation(prescriptionDtoList);
        if (validationResult.size() == 0)
            return prescriptionDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PrescriptionDto getById(Long id) throws SQLException, ValidationException {
        PrescriptionDto prescriptionDto = (PrescriptionDto) converter.getObject(prescriptionDaoImp.getById(id), PrescriptionDto.class);
        List<String> validationResult = prescriptionValidator.dtoValidation(prescriptionDto);
        if (validationResult.size()==0)
            return prescriptionDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PrescriptionDto prescriptionDto) throws  SQLException, ValidationException {
        Long visitId = prescriptionDto.getVisitId();
        List<String> validationResult = prescriptionValidator.dtoValidation(prescriptionDto);
        if (validationResult.size() == 0) {
            prescriptionDto.setId(null);
            PrescriptionEntity prescriptionEntity = (PrescriptionEntity) converter.getObject(prescriptionDto, PrescriptionEntity.class);
            prescriptionEntity.setVisitEntity(visitDaoImp.getById(visitId));
            prescriptionDaoImp.Add(prescriptionEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PrescriptionDto prescriptionDto) throws SQLException, ValidationException {
        Long visitId = prescriptionDto.getVisitId();
        List<String> validationResult = prescriptionValidator.dtoValidation(prescriptionDto);
        if (validationResult.size() == 0) {
            PrescriptionEntity prescriptionEntity = (PrescriptionEntity) converter.getObject(prescriptionDto, PrescriptionEntity.class);
            prescriptionEntity.setVisitEntity(visitDaoImp.getById(visitId));
            prescriptionDaoImp.edit(prescriptionEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        prescriptionDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        prescriptionDaoImp.removeAll();
    }
}
