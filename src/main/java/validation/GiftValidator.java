package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.GiftDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GiftValidator {

    public List<String> dtoValidation(GiftDto giftDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (giftDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (giftDto != null && (giftDto.getCause() == null
                    || giftDto.getCause().trim().equals(""))) {
                result.add(ValidationMessages.causeEmpty);
                messageCount++;
            }
            if (giftDto != null && (giftDto.getMablagh() == null
                    || giftDto.getMablagh().trim().equals(""))) {
                result.add(ValidationMessages.mablaghEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<GiftDto> giftDtoList){
        List<String> result = new ArrayList<>();
        if (giftDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
        else{
            List<String> tempList = new ArrayList<>();
            for (GiftDto giftDto : giftDtoList) {
                tempList = dtoValidation(giftDto);
                for (String r : tempList) {
                    result.add(r);
                }
            }
        }
//        for (GiftDto giftDto : giftDtoList) {
//            if (giftDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (giftDto != null && (giftDto.getName() == null || giftDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
