package validation;

import accessories.ValidationMessages;
import biz.dto.PatientDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PatientValidator {

    public List<String> dtoValidation(PatientDto patientDto) {
        List<String> result = new ArrayList<String>();
        if (patientDto==null)
            result.add(ValidationMessages.objectEmpty);
        if (patientDto!=null && patientDto.getCertificateCode() == null)
            result.add(ValidationMessages.ucodeEmpty);
        if (patientDto != null && (patientDto.getFatherName() == null || patientDto.getFatherName().trim().equals("")))
            result.add(ValidationMessages.fatherNameEmpty);
        if (patientDto != null && (patientDto.getFirstName() == null || patientDto.getFirstName().trim().equals("")))
            result.add(ValidationMessages.firstNameEmpty);
        if (patientDto != null && (patientDto.getHomeAddress() == null || patientDto.getHomeAddress().trim().equals("")))
            result.add(ValidationMessages.homeAddressEmpty);
        if (patientDto != null && (patientDto.getLastName() == null || patientDto.getLastName().trim().equals("")))
            result.add(ValidationMessages.lastNameEmpty);
        if (patientDto != null && patientDto.getPhoneNumber() == null)
            result.add(ValidationMessages.phoneNumberEmpty);
        if (patientDto != null && patientDto.getNationalCode() == null)
            result.add(ValidationMessages.uidEmpty);
        if (patientDto != null && (patientDto.getSex() == null || patientDto.getSex().trim().equals("")))
            result.add(ValidationMessages.sexEmpty);
        return result;
    }

    public List<String> listDtoValidation(List<PatientDto> patientDtoList){
        List<String> result = new ArrayList<>();
        if (patientDtoList.size() == 0)
            result.add(ValidationMessages.listEmpty);
//        for (PatientDto patientDto : patientDtoList) {
//            if (patientDto == null );
//                result.add(ValidationMessages.objectEmpty);
//            if (patientDto != null && (patientDto.getName() == null || patientDto.getName().trim().equals("")))
//                result.add(ValidationMessages.)
//        }
        return result;
    }
}
