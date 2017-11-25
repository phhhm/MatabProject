package validation;

import accessories.ValidationMessages;
import biz.dto.DrugDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DrugValidator {
    public List<String> dtoValidation(DrugDto drugDto) {
        List<String> result = new ArrayList<String>();
        if (drugDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (drugDto!=null && (drugDto.getName()== null || drugDto.getName().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
        if (drugDto != null && (drugDto.getTotalInventory() == null|| drugDto.getTotalInventory().trim().equals("")))
            result.add(ValidationMessages.totalInventoryEmpty);
        if (drugDto != null && (drugDto.getUnitType() == null || drugDto.getUnitType().trim().equals("")))
            result.add(ValidationMessages.unitTypeEmpty);
        return result;
    }

    public List<String> listDtoValidation(List<DrugDto> drugDtoList){
        List<String> result = new ArrayList<>();
        if (drugDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (DrugDto drugDto : drugDtoList) {
//            if (drugDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (drugDto != null && (drugDto.getName() == null || drugDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
