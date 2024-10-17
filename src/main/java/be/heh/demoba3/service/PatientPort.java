package be.heh.demoba3.service;

import be.heh.demoba3.model.Patient;

public interface PatientPort {
    void savePatient(Patient patient);
    Patient findById(Long id);
}
