package validation;

import accessories.ValidationMessages;
import biz.dto.DismissDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DismissValidator {
    public List<String> dtoValidation(DismissDto dismissDto) {
        List<String> result = new ArrayList<String>();
        if (dismissDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (dismissDto!=null && (dismissDto.getFromDate()== null
                || dismissDto.getFromDate().trim().equals("")))
                result.add(ValidationMessages.fromDateEmpty);
        if (dismissDto != null && (dismissDto.getUntilDate() == null
                || dismissDto.getUntilDate().trim().equals("")))
            result.add(ValidationMessages.untilDateEmpty);
        if (dismissDto != null && dismissDto.getEmployeeId() == null)
            result.add(ValidationMessages.employeeIdEmpty);
        return result;
    }

    public List<String> listDtoValidation(List<DismissDto> dismissDtoList){
        List<String> result = new ArrayList<>();
        if (dismissDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (DismissDto dismissDto : dismissDtoList) {
//            if (dismissDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (dismissDto != null && (dismissDto.getName() == null || dismissDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
