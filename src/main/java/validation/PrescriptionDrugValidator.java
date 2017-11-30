package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.PrescriptionDrugDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PrescriptionDrugValidator {
    public List<String> dtoValidation(PrescriptionDrugDto prescriptionDrugDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (prescriptionDrugDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (prescriptionDrugDto != null && prescriptionDrugDto.getConsumableDose() == null) {
                result.add(ValidationMessages.consumableDoseEmpty);
                messageCount++;
            }
            if (prescriptionDrugDto != null && prescriptionDrugDto.getDrugId() == null){
                result.add(ValidationMessages.drugIdEmpty);
                messageCount++;
            }
            if (prescriptionDrugDto != null && prescriptionDrugDto.getPrescriptionId() == null){
                result.add(ValidationMessages.prescriptionIdEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<PrescriptionDrugDto> prescriptionDrugDtoList){
        List<String> result = new ArrayList<>();
        if (prescriptionDrugDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (PrescriptionDrugDto prescriptionDrugDto : prescriptionDrugDtoList) {
//            if (prescriptionDrugDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (prescriptionDrugDto != null && (prescriptionDrugDto.getName() == null || prescriptionDrugDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
