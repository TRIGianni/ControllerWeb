package be.heh.demoba3.model;

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

public class Patient {
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private Integer age;

    private String email;

    private String bloodType;

    private Boolean consentGiven;

    //private List<String> preexistingConditions;

    private Integer policyNumber;

    private LocalDate registrationDate;

    private LocalDate dateOfBirth;

    private String insurerId;

    private String ssn;
}
