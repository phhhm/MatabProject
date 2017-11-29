package biz;

import biz.dto.FileDto;
import converter.MainConverter;
import dal.dao.FileDaoImp;
import dal.dao.PatientDaoImp;
import dal.dao.TransactionDaoImp;
import dal.entities.FileEntity;
import validation.FileValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by parham on 10/28/2017.
 */
@ApplicationScoped
public class FileBiz {

    @Inject
    private FileDaoImp fileDaoImp;

    @Inject
    private TransactionDaoImp transactionDaoImp;

    @Inject
    private PatientDaoImp patientDaoImp;

    @Inject
    private FileValidator fileValidator;

    @EJB
    private MainConverter converter;

    public List<FileDto> getAll() throws SQLException, ValidationException {
        List<FileDto> fileDtoList = converter.getList(fileDaoImp.getAll(), FileDto.class);
        List<String> validationResult = fileValidator.listDtoValidation(fileDtoList);
        if (validationResult.size() == 0)
            return fileDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public FileDto getById(Long id) throws SQLException, ValidationException {
        FileDto fileDto = (FileDto) converter.getObject(fileDaoImp.getById(id), FileDto.class);
        List<String> validationResult = fileValidator.dtoValidation(fileDto);
        if (validationResult.size()==0)
            return fileDto;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void add(FileDto fileDto) throws  SQLException, ValidationException {
        List<String> validationResult = fileValidator.dtoValidation(fileDto);
        if (validationResult.size() == 0) {
            Long patientId = fileDto.getPatientId();
            Long transactionId = fileDto.getTransactionId();
            fileDto.setId(null);
            FileEntity fileEntity = (FileEntity) converter.getObject(fileDto, FileEntity.class);
            fileEntity.setTransactionEntity(transactionDaoImp.getById(transactionId));
            fileEntity.setPatientEntity(patientDaoImp.getById(patientId));
            fileDaoImp.Add(fileEntity);
        }else {
            throw new ValidationException(String.join(",", validationResult));
        }
    }

    public void edit(FileDto fileDto) throws SQLException, ValidationException {
        List<String> validationResult = fileValidator.dtoValidation(fileDto);
        if (validationResult.size() == 0) {
            Long transactionId = fileDto.getTransactionId();
            Long patientId = fileDto.getPatientId();
            FileEntity fileEntity = (FileEntity) converter.getObject(fileDto, FileEntity.class);
            fileEntity.setTransactionEntity(transactionDaoImp.getById(transactionId));
            fileEntity.setPatientEntity(patientDaoImp.getById(patientId));
            fileDaoImp.edit(fileEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        fileDaoImp.removeById(id);
    }

    public void removeAll() throws SQLException {
        fileDaoImp.removeAll();
    }
}
