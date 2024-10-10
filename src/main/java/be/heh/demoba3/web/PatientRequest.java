package be.heh.demoba3.web;

import be.heh.demoba3.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class PatientRequest {

    private String firstName;

    private String middleName;

    private String lastName;

    private Integer age;

    private List<String> preexistingConditions;

    private Boolean consentGiven;

    private Integer policyNumber;

    private LocalDate registrationDate;

    private LocalDate dateOfBirth;

    private String email;

    private String bloodType;

    private String insurerId;

    public Patient toEntity() {
        return Patient.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .age(age)
                .email(email)
                .bloodType(bloodType)
                .consentGiven(consentGiven)
                .preexistingConditions(preexistingConditions)
                .policyNumber(policyNumber)
                .registrationDate(registrationDate)
                .dateOfBirth(dateOfBirth)
                .insurerId(insurerId)
                .build();
    }
}
