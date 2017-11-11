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
        if (patientDto!=null && (patientDto.getCertificateCode() == null
                || patientDto.getFatherName() == null
                || patientDto.getFirstName() == null
                || patientDto.getHomeAddress() == null
                || patientDto.getLastName() == null
                || patientDto.getPhoneNumber() == null
                || patientDto.getNationalCode() == null
                || patientDto.getSex() == null
                || patientDto.getLastName().trim().equals("")
                || patientDto.getFirstName().trim().equals("")
                || patientDto.getHomeAddress().trim().equals("")
                || patientDto.getSex().trim().equals("")
                || patientDto.getFatherName().trim().equals("")))
            result.add(ValidationMessages.fieldEmpty);
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
