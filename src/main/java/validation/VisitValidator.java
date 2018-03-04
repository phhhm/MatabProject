package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.VisitDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VisitValidator {

    public List<String> dtoValidation(VisitDto visitDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (visitDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (visitDto != null && (visitDto.getNextVisitDate() == null
                    || visitDto.getNextVisitDate().trim().equals(""))){
                result.add(ValidationMessages.nextVisitDateEmpty);
                messageCount++;
            }
            if (visitDto != null && (visitDto.getVisitDate() == null
                    || visitDto.getVisitDate().trim().equals(""))){
                result.add(ValidationMessages.dateEmpty);
                messageCount++;
            }
            if (visitDto != null && visitDto.getEmployeeId() == null){
                result.add(ValidationMessages.employeeIdEmpty);
                messageCount++;
            }
            if (visitDto != null && visitDto.getFileId() == null){
                result.add(ValidationMessages.fieldIdEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<VisitDto> visitDtoList){
        List<String> result = new ArrayList<>();
        if (visitDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (VisitDto visitDto : visitDtoList) {
//            if (visitDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (visitDto != null && (visitDto.getName() == null || visitDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
