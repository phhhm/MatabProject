package validation;

import accessories.ValidationMessages;
import biz.dto.ContractDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ContractValidator {
    public List<String> dtoValidation(ContractDto contractDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (contractDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (contractDto != null && contractDto.getEndContractTime() == null) {
                result.add(ValidationMessages.endContractEmpty);
                messageCount++;
            }
            if (contractDto != null && contractDto.getMablagh() == null) {
                result.add(ValidationMessages.mablaghEmpty);
                messageCount++;
            }
            if (contractDto != null && contractDto.getEmployeeId() == null) {
                result.add(ValidationMessages.employeeIdEmpty);
                messageCount++;
            }
            if (contractDto != null && contractDto.getStartContractTime() == null) {
                result.add(ValidationMessages.startContractEmpty);
                messageCount++;
            }
        }
        if (messageCount > 3){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
        return result;
    }

    public List<String> listDtoValidation(List<ContractDto> contractDtoList){
        List<String> result = new ArrayList<>();
        if (contractDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (ContractDto contractDto : contractDtoList) {
//            if (contractDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (contractDto != null && (contractDto.getName() == null || contractDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
