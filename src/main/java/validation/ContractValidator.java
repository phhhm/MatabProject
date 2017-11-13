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
        if (contractDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (contractDto!=null && (contractDto.getEndContractTime()== null
                || contractDto.getEndContractTime().trim().equals("")))
            result.add(ValidationMessages.endContractEmpty);
        if(contractDto != null && contractDto.getMablagh() == null)
            result.add(ValidationMessages.mablaghEmpty);
        if(contractDto != null && contractDto.getEmployeeId() == null)
            result.add(ValidationMessages.employeeEmpty);
        if (contractDto != null && (contractDto.getStartContractTime() == null
                || contractDto.getStartContractTime().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
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
