package biz;

import biz.dto.PrescriptionDrugDto;
import converter.MainConverter;
import dal.dao.DrugDaoImp;
import dal.dao.PrescriptionDaoImp;
import dal.dao.PrescriptionDrugDaoImp;
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
    private PrescriptionDrugDaoImp prescriptionDrugDaoImp;

    @Inject
    private DrugDaoImp drugDaoImp;

    @Inject
    private PrescriptionDaoImp prescriptionDaoImp;

    @Inject
    private PrescriptionDrugValidator prescriptionDrugValidator;

    @EJB
    private MainConverter converter;

    public List<PrescriptionDrugDto> getAll() throws SQLException, ValidationException {
        List<PrescriptionDrugDto> prescriptionDrugDtoList = converter.getList(prescriptionDrugDaoImp.getAll(), PrescriptionDrugDto.class);
        List<String> validationResult = prescriptionDrugValidator.listDtoValidation(prescriptionDrugDtoList);
        if (validationResult.size() == 0)
            return prescriptionDrugDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public PrescriptionDrugDto getById(Long id) throws SQLException, ValidationException {
        PrescriptionDrugDto prescriptionDrugDto = (PrescriptionDrugDto) converter.getObject(prescriptionDrugDaoImp.getById(id), PrescriptionDrugDto.class);
        List<String> validationResult = prescriptionDrugValidator.dtoValidation(prescriptionDrugDto);
        if (validationResult.size()==0)
            return prescriptionDrugDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(PrescriptionDrugDto prescriptionDrugDto) throws  SQLException, ValidationException {
        Long drugId = prescriptionDrugDto.getDrugId();
        Long prescriptionId = prescriptionDrugDto.getPrescriptionId();
        List<String> validationResult = prescriptionDrugValidator.dtoValidation(prescriptionDrugDto);
        if (validationResult.size() == 0) {
            prescriptionDrugDto.setId(null);
            PrescriptionDrugEntity prescriptionDrugEntity = (PrescriptionDrugEntity) converter.getObject(prescriptionDrugDto, PrescriptionDrugEntity.class);
            prescriptionDrugEntity.setDrugEntity(drugDaoImp.getById(drugId));
            prescriptionDrugEntity.setPrescriptionEntity(prescriptionDaoImp.getById(prescriptionId));
            prescriptionDrugDaoImp.Add(prescriptionDrugEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(PrescriptionDrugDto prescriptionDrugDto) throws SQLException, ValidationException {
        Long drugId = prescriptionDrugDto.getDrugId();
        Long prescriptionId = prescriptionDrugDto.getPrescriptionId();
        List<String> validationResult = prescriptionDrugValidator.dtoValidation(prescriptionDrugDto);
        if (validationResult.size() == 0) {
            PrescriptionDrugEntity prescriptionDrugEntity = (PrescriptionDrugEntity) converter.getObject(prescriptionDrugDto, PrescriptionDrugEntity.class);
            prescriptionDrugEntity.setDrugEntity(drugDaoImp.getById(drugId));
            prescriptionDrugEntity.setPrescriptionEntity(prescriptionDaoImp.getById(prescriptionId));
            prescriptionDrugDaoImp.edit(prescriptionDrugEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        prescriptionDrugDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        prescriptionDrugDaoImp.removeAll();
    }
}
