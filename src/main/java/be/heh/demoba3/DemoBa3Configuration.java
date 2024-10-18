package be.heh.demoba3;

import be.heh.demoba3.service.PatientPort;
import be.heh.demoba3.service.PatientService;
import be.heh.demoba3.service.PatientUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoBa3Configuration {
    @Autowired
    private PatientPort patientPort;

    @Bean
    PatientUseCase patientUseCase() {
        return new PatientService(patientPort);
    }
}
