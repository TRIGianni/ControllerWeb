package be.heh.demoba3.web;

import be.heh.demoba3.model.Patient;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class PatientRequest {

    @NotNull
    private String firstName;
    @NotEmpty
    private String middleName;

    @NotBlank
    private String lastName;

    @Min(value = 18)
    @Max(value = 120)
    private Integer age;

    private List<String> preexistingConditions;

    @AssertTrue
    private Boolean consentGiven;

    @Positive
    private Integer policyNumber;

    @FutureOrPresent
    private LocalDate registrationDate;

    @Past
    private LocalDate dateOfBirth;
    @Email
    private String email;

    @Pattern(regexp = "(A|B|AB|O)[+-]")
    private String bloodType;

    @UUID
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
