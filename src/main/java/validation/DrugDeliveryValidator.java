package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.DrugDeliveryDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DrugDeliveryValidator {
    public List<String> dtoValidation(DrugDeliveryDto drugDeliveryDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (drugDeliveryDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (drugDeliveryDto != null && (drugDeliveryDto.getDeliveryDate() == null
                    || drugDeliveryDto.getDeliveryDate().trim().equals(""))){

                result.add(ValidationMessages.deliveryDateEmpty);
                messageCount++;
            }
            if (drugDeliveryDto != null && (drugDeliveryDto.getSourceId() == null
                    || drugDeliveryDto.getSourceId().trim().equals(""))){
                result.add(ValidationMessages.sourceIdEmpty);
                messageCount++;
            }
            if (drugDeliveryDto != null && (drugDeliveryDto.getSourceType() == null
                    || drugDeliveryDto.getSourceType().trim().equals(""))){
                result.add(ValidationMessages.sourceTypeEmpty);
                messageCount++;
            }
            if (drugDeliveryDto != null && (drugDeliveryDto.getUseDuration() == null
                    || drugDeliveryDto.getUseDuration().trim().equals(""))){
                result.add(ValidationMessages.useDurationEmpty);
                messageCount++;
            }
            if (drugDeliveryDto != null && (drugDeliveryDto.getEmployeeId() == null)){
                result.add(ValidationMessages.employeeIdEmpty);
                messageCount++;
            }
            if (drugDeliveryDto != null && (drugDeliveryDto.getTransactionId() == null)){
                result.add(ValidationMessages.transactionIdEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
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
