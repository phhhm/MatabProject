package biz;

import biz.dto.DrugDeliveryDto;
import biz.dto.FileDto;
import biz.dto.PatientDto;
import biz.dto.TransactionDto;
import converter.MainConverter;
import dal.dao.FileDao;
import dal.dao.PatientDao;
import dal.dao.TransactionDao;
import dal.entities.FileEntity;
import validation.FileValidator;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parham on 10/28/2017.
 */
@ApplicationScoped
public class FileBiz {

    @Inject
    private FileDao fileDao;

    @Inject
    private TransactionDao transactionDao;

    @Inject
    private PatientDao patientDao;

    @Inject
    private FileValidator fileValidator;

    @Inject
    private TransactionBiz transactionBiz;

    @Inject
    private PatientBiz patientBiz;

    @EJB
    private MainConverter converter;

    public List<FileDto> getAll() throws SQLException, ValidationException {
        List<FileDto> fileDtoList = converter.getList(fileDao.getAll(), FileDto.class);
        List<String> validationResult = fileValidator.listDtoValidation(fileDtoList);
        if (validationResult.size() == 0)
            return fileDtoList;
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public FileDto getById(Long id) throws SQLException, ValidationException {
        FileDto fileDto = (FileDto) converter.getObject(fileDao.getById(id), FileDto.class);
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
            fileEntity.setTransactionEntity(transactionDao.getById(transactionId));
            fileEntity.setPatientEntity(patientDao.getById(patientId));
            fileDao.Add(fileEntity);
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
            fileEntity.setTransactionEntity(transactionDao.getById(transactionId));
            fileEntity.setPatientEntity(patientDao.getById(patientId));
            fileDao.edit(fileEntity);
        }
        else
            throw new ValidationException(String.join(",", validationResult));
    }

    public void remove(Long id) throws SQLException, ValidationException {
        if (id == null)
            throw new ValidationException();
        fileDao.removeById(id);
    }

    public void removeAll() throws SQLException {
        fileDao.removeAll();
    }

    public List<PatientDto> getPatientWithNoDuplicate() throws SQLException, ValidationException {
        List<PatientDto> temp = new ArrayList<>();
        List<FileDto> allFileDtoList = getAll();
        List<PatientDto> patientDtoList = patientBiz.getAll();

        for (FileDto fileDto : allFileDtoList) {
            for (PatientDto patientDto : patientDtoList) {
                if ((fileDto.getPatientId()) == (patientDto.getId())){
                    temp.add(patientDto);
                }
            }
        }
        patientDtoList.removeIf(temp::contains);

        return patientDtoList;
    }

    public List<TransactionDto> getTransactionWithNoDuplicate() throws SQLException, ValidationException {
        List<TransactionDto> temp = new ArrayList<>();
        List<FileDto> allFileDtoList = getAll();
        List<TransactionDto> transactionDtoList = transactionBiz.getAll();

        for (FileDto fileDto : allFileDtoList) {
            for (TransactionDto transactionDto : transactionDtoList) {
                if ((fileDto.getPatientId()) == (transactionDto.getId())){
                    temp.add(transactionDto);
                }
            }
        }
        transactionDtoList.removeIf(temp::contains);

        return transactionDtoList;
    }
}
