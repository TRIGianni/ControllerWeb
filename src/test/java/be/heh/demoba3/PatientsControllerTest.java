package be.heh.demoba3;

import be.heh.demoba3.model.Patient;
import be.heh.demoba3.service.PatientService;
import be.heh.demoba3.service.PatientUseCase;
import be.heh.demoba3.web.PatientsController;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
<<<<<<< HEAD
=======
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
>>>>>>> etape5
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PatientsController.class)
@ExtendWith(SpringExtension.class)
public class PatientsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PatientUseCase patientServiceMock;

    @Test
    @DisplayName("GET /patients/query?id=1 - Found")
    void testGetPatientsByIdFound() throws Exception {

        Patient patient = Patient.builder()
                .firstName("toto")
                .middleName("")
                .lastName("titi")
                .email("toto@hotmail.com")
                .id(1L)
                .insurerId("kllklk").build();

        //PatientUseCase patientServiceMock = mock(PatientUseCase.class);
        when(patientServiceMock.findById(1L)).thenReturn(patient);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/patients/query?id=1");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo("toto")))
                .andExpect(jsonPath("$.lastName", equalTo("titi")))
                .andExpect(jsonPath("$.email", equalTo("toto@hotmail.com")))
                .andExpect(jsonPath("$.id", equalTo(1)));
    }
}
