package validation;

import accessories.ValidationMessages;
import biz.dto.MainStorageDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class MainStorageValidator {

    public List<String> dtoValidation(MainStorageDto mainStorageDto) {
        List<String> result = new ArrayList<String>();
        if (mainStorageDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (mainStorageDto!=null && mainStorageDto.getDrugAmountInUnit() == null)
            result.add(ValidationMessages.drugAmountInUnitEmpty);
        if (mainStorageDto != null && mainStorageDto.getDrugDeliveryId() == null)
            result.add(ValidationMessages.drugDeliveryIdEmpty);
        if (mainStorageDto != null && mainStorageDto.getDrugId() == null)
            result.add(ValidationMessages.drugIdEmpty);
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
