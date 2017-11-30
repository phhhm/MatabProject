package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.FileDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FileValidator {
    public List<String> dtoValidation(FileDto fileDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (fileDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (fileDto != null && (fileDto.getConsumableDrugs() == null
                    || fileDto.getConsumableDrugs().trim().equals(""))) {
                result.add(ValidationMessages.consumableDragEmpty);
                messageCount++;
            }
            if (fileDto != null && fileDto.getFileCode() == null){
                result.add(ValidationMessages.fileCodeEmpty);
                messageCount++;
            }
            if (fileDto != null && (fileDto.getDescription() == null
                    || fileDto.getDescription().trim().equals(""))){
                result.add(ValidationMessages.descriptionEmpty);
                messageCount++;
            }
            if (fileDto != null && fileDto.getStartDate() == null){
                result.add(ValidationMessages.startDateEmpty);
                messageCount++;
            }
            if (fileDto != null && fileDto.getPatientId() == null){
                result.add(ValidationMessages.patientIdEmpty);
                messageCount++;
            }
            if (fileDto != null && fileDto.getTransactionId() == null){
                result.add(ValidationMessages.transactionIdEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<FileDto> fileDtoList){
        List<String> result = new ArrayList<>();
        if (fileDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (FileDto fileDto : fileDtoList) {
//            if (fileDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (fileDto != null && (fileDto.getName() == null || fileDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
