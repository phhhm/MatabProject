package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.MainStorageDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MainStorageValidator {

    public List<String> dtoValidation(MainStorageDto mainStorageDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (mainStorageDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (mainStorageDto != null && mainStorageDto.getDrugAmountInUnit() == null) {
                result.add(ValidationMessages.drugAmountInUnitEmpty);
                messageCount++;
            }
            if (mainStorageDto != null && mainStorageDto.getDrugDeliveryId() == null){
                result.add(ValidationMessages.drugDeliveryIdEmpty);
                messageCount++;
            }
            if (mainStorageDto != null && mainStorageDto.getDrugId() == null){
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

    public List<String> listDtoValidation(List<MainStorageDto> mainStorageDtoList){
        List<String> result = new ArrayList<>();
        if (mainStorageDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (MainStorageDto mainStorageDto : mainStorageDtoList) {
//            if (mainStorageDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (mainStorageDto != null && (mainStorageDto.getName() == null || mainStorageDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
