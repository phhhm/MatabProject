package validation;

import accessories.ValidationMessages;
import biz.dto.PartialStorageDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PartialStorageValidator {

    public List<String> dtoValidation(PartialStorageDto partialStorageDto) {
        List<String> result = new ArrayList<String>();
        if (partialStorageDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (partialStorageDto!=null && (partialStorageDto.getDrugAmountInUnit()== null
        || partialStorageDto.getDrugDeliveryId() == null
        || partialStorageDto.getDrugId() == null))
            result.add(ValidationMessages.fieldEmpty);
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
