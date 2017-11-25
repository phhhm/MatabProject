package validation;

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
        if (employeeDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (employeeDto!=null && (employeeDto.getAbility()== null || employeeDto.getAbility().trim().equals("")))
            result.add(ValidationMessages.abilityEmpty);
        if (employeeDto != null && (employeeDto.getDegree() == null || employeeDto.getDegree().trim().equals("")))
            result.add(ValidationMessages.degreeEmployeeEmpty);
        if (employeeDto != null && employeeDto.getEmployeeCode() == null)
            result.add(ValidationMessages.employeeCodeEmpty);
        if (employeeDto != null && (employeeDto.getEmployeeType() == null || employeeDto.getEmployeeType().trim().equals("")))
            result.add(ValidationMessages.employeeTypeEmpty);
        if (employeeDto != null && (employeeDto.getFirstName() == null || employeeDto.getFirstName().trim().equals("")))
            result.add(ValidationMessages.firstNameEmpty);
        if (employeeDto != null && (employeeDto.getHomeAddress() == null || employeeDto.getHomeAddress().trim().equals("")))
            result.add(ValidationMessages.homeAddressEmpty);
        if (employeeDto != null && employeeDto.getImage() == null)
            result.add(ValidationMessages.imageEmpty);
        if (employeeDto != null && (employeeDto.getLastName() == null || employeeDto.getLastName().trim().equals("")))
            result.add(ValidationMessages.lastNameEmpty);
        if (employeeDto != null && employeeDto.getPhoneNumber() == null)
            result.add(ValidationMessages.phoneNumberEmpty);
        if (employeeDto != null && employeeDto.getRemainMorekhasi() == null)
            result.add(ValidationMessages.remainMorekhasiEmpty);
        if (employeeDto != null && employeeDto.getUcode() == null)
            result.add(ValidationMessages.ucodeEmpty);
        if (employeeDto != null && employeeDto.getUid() == null)
            result.add(ValidationMessages.uidEmpty);
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
