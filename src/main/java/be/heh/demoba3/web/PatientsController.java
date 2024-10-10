package be.heh.demoba3.web;

import be.heh.demoba3.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    private static final Logger log = LoggerFactory.getLogger(PatientsController.class);
    private List<Patient> patients = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        List<PatientResponse> listPatients = patients.stream()
                .map(patient -> PatientResponse.fromEntity(patient))
                .collect(toList());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(listPatients);
    }

    @GetMapping("/query")
    public ResponseEntity<PatientResponse> getOnePatient(@RequestParam("id") Long id) {
        Patient patient = patients.get(Math.toIntExact(id)-1);
        PatientResponse patientResponse = PatientResponse.fromEntity(patient);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(patientResponse);
    }

    @PostMapping
    public ResponseEntity<Void> createPatient(
            @RequestBody PatientRequest patientRequest) {

        //stocke
        Patient patient = patientRequest.toEntity();
        patient.setId(1L);
        patients.add(patient);
        //Data envoyée
        String url = "http://localhost:8080/patients/" + patient.getId();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location",url)
                .build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable("id") int id) {
        patients.remove(id-1);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}