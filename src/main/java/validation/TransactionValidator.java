package validation;

import accessories.ValidationMessages;
import biz.dto.TransactionDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TransactionValidator {
    public List<String> dtoValidation(TransactionDto transactionDto) {
        List<String> result = new ArrayList<String>();
        if (transactionDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (transactionDto!=null && (transactionDto.getDate()== null
                || transactionDto.getMablagh() == null
                || transactionDto.getType() == null
                || transactionDto.getPaymentId() == null
                || transactionDto.getType().trim().equals("")
                || transactionDto.getDate().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
        return result;
    }

    public List<String> listDtoValidation(List<TransactionDto> transactionDtoList){
        List<String> result = new ArrayList<>();
        if (transactionDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (TransactionDto transactionDto : transactionDtoList) {
//            if (transactionDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (transactionDto != null && (transactionDto.getName() == null || transactionDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
