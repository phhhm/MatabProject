package validation;

import accessories.ValidationMessages;
import biz.dto.PaymentDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PaymentValidator {
    public List<String> dtoValidation(PaymentDto paymentDto) {
        List<String> result = new ArrayList<String>();
        if (paymentDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (paymentDto!=null && (paymentDto.getBime()== null
                || paymentDto.getKasri() == null
                || paymentDto.getMainPayment() == null
                || paymentDto.getMaliat() == null
                || paymentDto.getEmployeeId() == null
                || paymentDto.getSanavat() == null))
            result.add(ValidationMessages.fieldEmpty);
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
