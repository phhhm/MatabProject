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
        if (transactionDto!=null && transactionDto.getDate()== null)
            result.add(ValidationMessages.dateEmpty);
        if (transactionDto != null && transactionDto.getMablagh() == null)
            result.add(ValidationMessages.mablaghEmpty);
        if (transactionDto != null && (transactionDto.getType() == null || transactionDto.getType().trim().equals("")))
            result.add(ValidationMessages.typeEmpty);
        if (transactionDto != null && transactionDto.getPaymentId() == null)
            result.add(ValidationMessages.paymentIdEmpty);
        if (transactionDto != null && transactionDto.getTransactionSourceId() == null)
            result.add(ValidationMessages.transactionSourceIdEmpty);
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
