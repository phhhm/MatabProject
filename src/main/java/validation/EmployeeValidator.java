package validation;

import accessories.Helper;
import accessories.ValidationMessages;
import biz.dto.EmployeeDto;
import javafx.scene.chart.ValueAxis;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmployeeValidator {

    public List<String> dtoValidation(EmployeeDto employeeDto) {
        List<String> result = new ArrayList<String>();
        int messageCount=0;
        if (employeeDto==null)
            result.add(ValidationMessages.objectEmpty);
        else {
            if (employeeDto != null && (employeeDto.getAbility() == null
                    || employeeDto.getAbility().trim().equals(""))) {
                result.add(ValidationMessages.abilityEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getDegree() == null
                    || employeeDto.getDegree().trim().equals(""))){
                result.add(ValidationMessages.degreeEmployeeEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getEmployeeCode() == null
                    || employeeDto.getEmployeeCode().trim().equals(""))){
                result.add(ValidationMessages.employeeCodeEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getEmployeeType() == null
                    || employeeDto.getEmployeeType().trim().equals(""))){
                result.add(ValidationMessages.employeeTypeEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getFirstName() == null
                    || employeeDto.getFirstName().trim().equals(""))){
                result.add(ValidationMessages.firstNameEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getHomeAddress() == null
                    || employeeDto.getHomeAddress().trim().equals(""))){
                result.add(ValidationMessages.homeAddressEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getImage() == null
                    || employeeDto.getImage().trim().equals(""))){
                result.add(ValidationMessages.imageEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getLastName() == null
                    || employeeDto.getLastName().trim().equals(""))){
                result.add(ValidationMessages.lastNameEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getPhoneNumber() == null
                    || employeeDto.getPhoneNumber().trim().equals(""))){
                result.add(ValidationMessages.phoneNumberEmpty);
                messageCount++;
            }
            if (employeeDto != null && employeeDto.getRemainMorekhasi() == null){
                result.add(ValidationMessages.remainMorekhasiEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getUcode() == null
                    || employeeDto.getUcode().trim().equals(""))){
                result.add(ValidationMessages.ucodeEmpty);
                messageCount++;
            }
            if (employeeDto != null && (employeeDto.getUid() == null
                    || employeeDto.getUid().trim().equals(""))){
                result.add(ValidationMessages.uidEmpty);
                messageCount++;
            }
        }
        if (messageCount > Helper.messageCount){
            result.clear();
            result.add(ValidationMessages.objectEmpty);
        }
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
