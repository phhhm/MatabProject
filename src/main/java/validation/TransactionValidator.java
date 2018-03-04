package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.TransactionDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TransactionValidator {
    public List<String> dtoValidation(TransactionDto transactionDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (transactionDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (transactionDto != null && (transactionDto.getDate() == null
                || transactionDto.getType().trim().equals(""))){
                result.add(ValidationMessages.dateEmpty);
                messageCount++;
            }
            if (transactionDto != null && (transactionDto.getMablagh() == null
                    || transactionDto.getType().trim().equals(""))){
                result.add(ValidationMessages.mablaghEmpty);
                messageCount++;
            }
            if (transactionDto != null && (transactionDto.getType() == null
                    || transactionDto.getType().trim().equals(""))){
                result.add(ValidationMessages.typeEmpty);
                messageCount++;
            }
            if (transactionDto != null && transactionDto.getPaymentId() == null){
                result.add(ValidationMessages.paymentIdEmpty);
                messageCount++;
            }
            if (transactionDto != null && (transactionDto.getTransactionSourceId() == null
                    || transactionDto.getType().trim().equals(""))){
                result.add(ValidationMessages.transactionSourceIdEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
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
