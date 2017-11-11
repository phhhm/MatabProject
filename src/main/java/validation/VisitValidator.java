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
        if (visitDto!=null && (visitDto.getNextVisitDate()== null
                || visitDto.getVisitDate() == null
                || visitDto.getEmployeeId() == null
                || visitDto.getFileId() == null
                || visitDto.getNextVisitDate().trim().equals("")
                || visitDto.getVisitDate().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
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
