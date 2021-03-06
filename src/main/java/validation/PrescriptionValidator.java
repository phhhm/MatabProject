package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.PrescriptionDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PrescriptionValidator {

    public List<String> dtoValidation(PrescriptionDto prescriptionDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (prescriptionDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (prescriptionDto != null && prescriptionDto.getVisitId() == null)
                result.add(ValidationMessages.visitIdEmpty);
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation( List<PrescriptionDto> prescriptionDtoList ){
        List<String> result = new ArrayList<>();
        if (prescriptionDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (PrescriptionDto prescriptionDto : prescriptionDtoList) {
//            if (prescriptionDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (prescriptionDto != null && (prescriptionDto.getName() == null || prescriptionDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
