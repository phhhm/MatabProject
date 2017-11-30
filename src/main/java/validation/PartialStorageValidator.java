package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.PartialStorageDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PartialStorageValidator {

    public List<String> dtoValidation(PartialStorageDto partialStorageDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (partialStorageDto == null)
            result.add(ValidationMessages.objectEmpty);
        else {
        if (partialStorageDto != null && partialStorageDto.getDrugAmountInUnit() == null) {
            result.add(ValidationMessages.drugAmountInUnitEmpty);
            messageCount++;
        }
        if (partialStorageDto != null && partialStorageDto.getDrugDeliveryId() == null){
            result.add(ValidationMessages.drugDeliveryIdEmpty);
            messageCount++;
        }
        if (partialStorageDto != null && partialStorageDto.getDrugId() == null){
            result.add(ValidationMessages.drugIdEmpty);
            messageCount++;
        }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<PartialStorageDto> partialStorageDtoList){
        List<String> result = new ArrayList<>();
        if (partialStorageDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (PartialStorageDto partialStorageDto : partialStorageDtoList) {
//            if (partialStorageDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (partialStorageDto != null && (partialStorageDto.getName() == null || partialStorageDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
