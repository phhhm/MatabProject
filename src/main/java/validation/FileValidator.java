package validation;

import accessories.ValidationMessages;
import biz.dto.FileDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FileValidator {
    public List<String> dtoValidation(FileDto fileDto) {
        List<String> result = new ArrayList<String>();
        if (fileDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (fileDto!=null && (fileDto.getConsumableDose()== null
                || fileDto.getConsumableDrugs() == null
                || fileDto.getFileCode() == null
                || fileDto.getPrescription() == null
                || fileDto.getDescription() == null
                || fileDto.getPatientId() == null
                || fileDto.getTransactionId() == null
                || fileDto.getDescription().trim().equals("")
                || fileDto.getPrescription().trim().equals("")
                || fileDto.getConsumableDrugs().trim().equals("")
                || fileDto.getConsumableDose().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
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
