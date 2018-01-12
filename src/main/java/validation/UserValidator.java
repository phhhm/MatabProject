package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.UserDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserValidator {
    public List<String> dtoValidation(UserDto userDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (userDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (userDto != null && (userDto.getUsername() == null
                    || userDto.getUsername().trim().equals(""))) {
                result.add(ValidationMessages.usernameEmpty);
                messageCount++;
            }
            if (userDto != null && (userDto.getPassword() == null
                    || userDto.getPassword().trim().equals(""))) {
                result.add(ValidationMessages.passwordEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<UserDto> userDtoList){
        List<String> result = new ArrayList<>();
        if (userDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (UserDto userDto : userDtoList) {
//            if (userDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (userDto != null && (userDto.getName() == null || userDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
