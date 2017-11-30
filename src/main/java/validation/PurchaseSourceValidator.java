package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.PurchaseSourceDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PurchaseSourceValidator {

    public List<String> dtoValidation(PurchaseSourceDto purchaseSourceDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (purchaseSourceDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (purchaseSourceDto != null && (purchaseSourceDto.getName() == null
                    || purchaseSourceDto.getName().trim().equals(""))) {
                result.add(ValidationMessages.fieldEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<PurchaseSourceDto> purchaseSourceDtoList){
        List<String> result = new ArrayList<>();
        if (purchaseSourceDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (PurchaseSourceDto purchaseSourceDto : purchaseSourceDtoList) {
//            if (purchaseSourceDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (purchaseSourceDto != null && (purchaseSourceDto.getName() == null || purchaseSourceDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }

//    public List<String> entityValidation(PurchaseSourceEntity purchaseSourceEntity){
//        List<String> result = new ArrayList<>();
//        if (purchaseSourceEntity == null)
//            result.add(ValidationMessages.objectEmpty);
//        if (purchaseSourceEntity!=null && ((purchaseSourceEntity.getName() == null && purchaseSourceEntity.getId() == null) || !purchaseSourceEntity.getName().trim().equals(""))
//            result.add(ValidationMessages.)
//    }
}
