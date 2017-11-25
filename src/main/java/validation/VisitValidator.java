package validation;

import accessories.ValidationMessages;
import biz.dto.VisitDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VisitValidator {

    public List<String> dtoValidation(VisitDto visitDto) {
        List<String> result = new ArrayList<String>();
        if (visitDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (visitDto!=null && visitDto.getNextVisitDate()== null)
            result.add(ValidationMessages.nextVisitDateEmpty);
        if (visitDto != null && visitDto.getVisitDate() == null)
            result.add(ValidationMessages.dateEmpty);
        if (visitDto != null && visitDto.getEmployeeId() == null)
            result.add(ValidationMessages.employeeIdEmpty);
        if (visitDto != null && visitDto.getFileId() == null)
            result.add(ValidationMessages.fieldIdEmpty);
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
