package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.PaymentDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PaymentValidator {
    public List<String> dtoValidation(PaymentDto paymentDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (paymentDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (paymentDto != null && paymentDto.getBime() == null) {
                result.add(ValidationMessages.bimeEmpty);
                messageCount++;
            }
            if (paymentDto != null && paymentDto.getMainPayment() == null){
                result.add(ValidationMessages.mainPaymentEmpty);
                messageCount++;
            }
            if (paymentDto != null && paymentDto.getMaliat() == null){
                result.add(ValidationMessages.maliatEmpty);
                messageCount++;
            }
            if (paymentDto != null && paymentDto.getEmployeeId() == null){
                result.add(ValidationMessages.employeeIdEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<PaymentDto> paymentDtoList){
        List<String> result = new ArrayList<>();
        if (paymentDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (PaymentDto paymentDto : paymentDtoList) {
//            if (paymentDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (paymentDto != null && (paymentDto.getName() == null || paymentDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
