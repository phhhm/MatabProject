package validation;

import accessories.ValidationMessages;
import biz.dto.DrugDeliveryDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DrugDeliveryValidator {
    public List<String> dtoValidation(DrugDeliveryDto drugDeliveryDto) {
        List<String> result = new ArrayList<String>();
        if (drugDeliveryDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (drugDeliveryDto!=null && (drugDeliveryDto.getDeliveryDate()== null
                || drugDeliveryDto.getSourceId() == null
                || drugDeliveryDto.getSourceType() == null
                || drugDeliveryDto.getUseDuration() == null
                || drugDeliveryDto.getEmployeeId() == null
                || drugDeliveryDto.getTransactionId() == null
                || drugDeliveryDto.getSourceType().trim().equals("")
                || drugDeliveryDto.getDeliveryDate().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
        return result;
    }

    public List<String> listDtoValidation(List<DrugDeliveryDto> drugDeliveryDtoList){
        List<String> result = new ArrayList<>();
        if (drugDeliveryDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (DrugDeliveryDto drugDeliveryDto : drugDeliveryDtoList) {
//            if (drugDeliveryDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (drugDeliveryDto != null && (drugDeliveryDto.getName() == null || drugDeliveryDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
