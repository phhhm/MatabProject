package validation;

import accessories.ValidationMessages;
import biz.dto.PresentTimeDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PresentTimeValidator {
    public List<String> dtoValidation(PresentTimeDto presentTimeDto) {
        List<String> result = new ArrayList<String>();
        if (presentTimeDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (presentTimeDto!=null && (presentTimeDto.getEndTime()== null
                || presentTimeDto.getStartTime() == null
                || presentTimeDto.getWeekDay() == null
                || presentTimeDto.getEmployeeId() == null
                || presentTimeDto.getWeekDay().trim().equals("")
                || presentTimeDto.getStartTime().trim().equals("")
                || presentTimeDto.getEndTime().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
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
