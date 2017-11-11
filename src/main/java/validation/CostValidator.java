package validation;

import accessories.ValidationMessages;
import biz.dto.CostDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CostValidator {
    public List<String> dtoValidation(CostDto costDto) {
        List<String> result = new ArrayList<String>();
        if (costDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (costDto!=null && (costDto.getBuy()== null
                || costDto.getSell() == null
                || costDto.getDate() == null
                || costDto.getDrugId() == null
                || costDto.getDate().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
        return result;
    }

    public List<String> listDtoValidation(List<CostDto> costDtoList){
        List<String> result = new ArrayList<>();
        if (costDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (CostDto costDto : costDtoList) {
//            if (costDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (costDto != null && (costDto.getName() == null || costDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
