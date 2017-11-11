package validation;

import accessories.ValidationMessages;
import biz.dto.EmployeeDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmployeeValidator {

    public List<String> dtoValidation(EmployeeDto employeeDto) {
        List<String> result = new ArrayList<String>();
        if (employeeDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (employeeDto!=null && (employeeDto.getAbility()== null
                || employeeDto.getDegree() == null
                || employeeDto.getEmployeeCode() == null
                || employeeDto.getEmployeeType() == null
                || employeeDto.getFirstName() == null
                || employeeDto.getHomeAddress() == null
                || employeeDto.getImage() == null
                || employeeDto.getLastName() == null
                || employeeDto.getPhoneNumber() == null
                || employeeDto.getRemainMorekhasi() == null
                || employeeDto.getUcode() == null
                || employeeDto.getUid() == null
                || employeeDto.getLastName().trim().equals("")
                || employeeDto.getFirstName().trim().equals("")
                || employeeDto.getHomeAddress().trim().equals("")
                || employeeDto.getEmployeeType().trim().equals("")
                || employeeDto.getDegree().trim().equals("")
                || employeeDto.getAbility().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
        return result;
    }

    public List<String> listDtoValidation(List<EmployeeDto> employeeDtoList){
        List<String> result = new ArrayList<>();
        if (employeeDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (EmployeeDto employeeDto : employeeDtoList) {
//            if (employeeDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (employeeDto != null && (employeeDto.getName() == null || employeeDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
