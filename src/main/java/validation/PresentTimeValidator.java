package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.PresentTimeDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PresentTimeValidator {
    public List<String> dtoValidation(PresentTimeDto presentTimeDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (presentTimeDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (presentTimeDto != null && (presentTimeDto.getEndTime() == null
                    || presentTimeDto.getEndTime().trim().equals(""))){
                result.add(ValidationMessages.endTimeEmpty);
                messageCount++;
            }
            if (presentTimeDto != null && (presentTimeDto.getStartTime() == null
                    || presentTimeDto.getStartTime().trim().equals(""))){
                result.add(ValidationMessages.startTimeEmpty);
                messageCount++;
            }
            if (presentTimeDto != null && (presentTimeDto.getWeekDay() == null
                    || presentTimeDto.getWeekDay().trim().equals(""))){
                result.add(ValidationMessages.weekDayEmpty);
                messageCount++;
            }
            if (presentTimeDto != null && presentTimeDto.getEmployeeId() == null){
                result.add(ValidationMessages.employeeIdEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<PresentTimeDto> presentTimeDtoList){
        List<String> result = new ArrayList<>();
        if (presentTimeDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (PresentTimeDto presentTimeDto : presentTimeDtoList) {
//            if (presentTimeDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (presentTimeDto != null && (presentTimeDto.getName() == null || presentTimeDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
