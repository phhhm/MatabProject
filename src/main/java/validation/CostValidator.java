package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.CostDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CostValidator {
    public List<String> dtoValidation(CostDto costDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (costDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (costDto != null && costDto.getBuy() == null) {
                result.add(ValidationMessages.buyEmpty);
                messageCount++;
            }
            if (costDto != null && costDto.getSell() == null) {
                result.add(ValidationMessages.sellEmpty);
                messageCount++;
            }
            if (costDto != null && costDto.getDate() == null) {
                result.add(ValidationMessages.dateEmpty);
                messageCount++;
            }
            if (costDto != null && costDto.getDrugId() == null) {
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
