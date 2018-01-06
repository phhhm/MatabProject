package biz;

import biz.dto.PrescriptionDrugDto;
import converter.MainConverter;
import dal.dao.DrugDao;
import dal.dao.PrescriptionDao;
import dal.dao.PrescriptionDrugDao;
import dal.entities.PrescriptionDrugEntity;
import validation.PrescriptionDrugValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class PrescriptionDrugBiz {

    @Inject
    private PrescriptionDrugDao prescriptionDrugDao;

    @Inject
    private DrugDao drugDao;

    @Inject
    private PrescriptionDao prescriptionDao;

    @Inject
    private PrescriptionDrugValidator prescriptionDrugValidator;

    @EJB
    private MainConverter converter;

    public List<PrescriptionDrugDto> getAll() throws SQLException, ValidationException {
        List<PrescriptionDrugDto> prescriptionDrugDtoList = converter.getList(prescriptionDrugDao.getAll(), PrescriptionDrugDto.class);
        List<String> validationResult = prescriptionDrugValidator.listDtoValidation(prescriptionDrugDtoList);
        if (validationResult.size() == 0)
            return prescriptionDrugDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PrescriptionDrugDto getById(Long id) throws SQLException, ValidationException {
        PrescriptionDrugDto prescriptionDrugDto = (PrescriptionDrugDto) converter.getObject(prescriptionDrugDao.getById(id), PrescriptionDrugDto.class);
        List<String> validationResult = prescriptionDrugValidator.dtoValidation(prescriptionDrugDto);
        if (validationResult.size()==0)
            return prescriptionDrugDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PrescriptionDrugDto prescriptionDrugDto) throws  SQLException, ValidationException {
        List<String> validationResult = prescriptionDrugValidator.dtoValidation(prescriptionDrugDto);
        if (validationResult.size() == 0) {
            Long drugId = prescriptionDrugDto.getDrugId();
            Long prescriptionId = prescriptionDrugDto.getPrescriptionId();
            prescriptionDrugDto.setId(null);
            PrescriptionDrugEntity prescriptionDrugEntity = (PrescriptionDrugEntity) converter.getObject(prescriptionDrugDto, PrescriptionDrugEntity.class);
            prescriptionDrugEntity.setDrugEntity(drugDao.getById(drugId));
            prescriptionDrugEntity.setPrescriptionEntity(prescriptionDao.getById(prescriptionId));
            prescriptionDrugDao.Add(prescriptionDrugEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PrescriptionDrugDto prescriptionDrugDto) throws SQLException, ValidationException {
        List<String> validationResult = prescriptionDrugValidator.dtoValidation(prescriptionDrugDto);
        if (validationResult.size() == 0) {
            Long drugId = prescriptionDrugDto.getDrugId();
            Long prescriptionId = prescriptionDrugDto.getPrescriptionId();
            PrescriptionDrugEntity prescriptionDrugEntity = (PrescriptionDrugEntity) converter.getObject(prescriptionDrugDto, PrescriptionDrugEntity.class);
            prescriptionDrugEntity.setDrugEntity(drugDao.getById(drugId));
            prescriptionDrugEntity.setPrescriptionEntity(prescriptionDao.getById(prescriptionId));
            prescriptionDrugDao.edit(prescriptionDrugEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        prescriptionDrugDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        prescriptionDrugDao.removeAll();
    }
}
