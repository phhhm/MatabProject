package validation;

import accessories.ValidationMessages;
import biz.dto.PrescriptionDrugDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PrescriptionDrugValidator {
    public List<String> dtoValidation(PrescriptionDrugDto prescriptionDrugDto) {
        List<String> result = new ArrayList<String>();
        if (prescriptionDrugDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (prescriptionDrugDto!=null && prescriptionDrugDto.getConsumableDose()== null)
            result.add(ValidationMessages.consumableDoseEmpty);
        if (prescriptionDrugDto != null && prescriptionDrugDto.getDrugId() == null)
            result.add(ValidationMessages.drugIdEmpty);
        if (prescriptionDrugDto != null && prescriptionDrugDto.getPrescriptionId() == null)
            result.add(ValidationMessages.prescriptionIdEmpty);
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
