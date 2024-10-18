package be.heh.demoba3.service;

import be.heh.demoba3.model.Patient;

import java.util.List;

public interface PatientUseCase {
    Patient findById(Long id);
    List<Patient> findAll();
    void save(Patient patient);
    void delete(Long id);
}
