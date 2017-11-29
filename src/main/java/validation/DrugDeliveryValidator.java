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
        if (drugDeliveryDto!=null && drugDeliveryDto.getDeliveryDate()== null)
            result.add(ValidationMessages.deliveryDateEmpty);
        if (drugDeliveryDto!= null && drugDeliveryDto.getSourceId() == null)
            result.add(ValidationMessages.sourceIdEmpty);
        if (drugDeliveryDto!= null && (drugDeliveryDto.getSourceType() == null || drugDeliveryDto.getSourceType().trim().equals("")))
            result.add(ValidationMessages.sourceTypeEmpty);
        if (drugDeliveryDto != null && drugDeliveryDto.getUseDuration() == null)
            result.add(ValidationMessages.useDurationEmpty);
        if (drugDeliveryDto != null && drugDeliveryDto.getEmployeeId() == null)
            result.add(ValidationMessages.employeeIdEmpty);
        if (drugDeliveryDto != null && drugDeliveryDto.getTransactionId() == null)
            result.add(ValidationMessages.transactionIdEmpty);
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
