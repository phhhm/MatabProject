package validation;

import accessories.ValidationMessages;
import biz.dto.GiftDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GiftValidator {

    public List<String> dtoValidation(GiftDto giftDto) {
        List<String> result = new ArrayList<String>();
        if (giftDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (giftDto != null && (giftDto.getCause() == null || giftDto.getCause().trim().equals("")))
                result.add(ValidationMessages.causeEmpty);
            if (giftDto != null && giftDto.getMablagh() == null)
                result.add(ValidationMessages.mablaghEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<GiftDto> giftDtoList){
        List<String> result = new ArrayList<>();
        if (giftDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (GiftDto giftDto : giftDtoList) {
//            if (giftDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (giftDto != null && (giftDto.getName() == null || giftDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
