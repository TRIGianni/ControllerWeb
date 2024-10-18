package be.heh.demoba3.service;

import be.heh.demoba3.model.Patient;

import java.util.List;

public class PatientService implements PatientUseCase {
    private PatientPort patientPort;

    public PatientService(PatientPort patientPort){
        this.patientPort = patientPort;
    }
    @Override
    public Patient findById(Long id) {
        return patientPort.findById(id);
    }

    @Override
    public List<Patient> findAll() {
        return List.of();
    }

    @Override
    public void save(Patient patient) {
        patientPort.savePatient(patient);
    }

    @Override
    public void delete(Long id) {

    }
}
