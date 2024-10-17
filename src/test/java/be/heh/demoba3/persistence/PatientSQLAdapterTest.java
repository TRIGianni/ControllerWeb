package be.heh.demoba3.persistence;

import be.heh.demoba3.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@ActiveProfiles("test")
@AutoConfigureJdbc
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@Import({PatientSQLAdapter.class,PatientRowMapper.class})

public class PatientSQLAdapterTest {

    @Autowired
    PatientSQLAdapter patientSQLAdapter;

    @Test
    @Sql({"/db/Create_Patients_Table.sql"})
    public void checkingPatientRegistration() {
        LocalDate registrationDate = LocalDate.now();
        LocalDate dateOfBirth = registrationDate.minusMonths(1);
        Patient patient = Patient.builder()
                .firstName("toto")
                .middleName("")
                .lastName("titi")
                .email("toto@hotmail.com")
                .registrationDate(registrationDate)
                .dateOfBirth(dateOfBirth)
                .build();

        patientSQLAdapter.savePatient(patient);

        Patient loadedPatient = patientSQLAdapter.findById(1L);

        Assertions.assertEquals("toto", loadedPatient.getFirstName());
        Assertions.assertEquals("titi", loadedPatient.getLastName());
        Assertions.assertEquals("toto@hotmail.com", loadedPatient.getEmail());
    }
}
