package be.heh.demoba3.persistence;

import be.heh.demoba3.model.Patient;
import be.heh.demoba3.service.PatientPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PatientSQLAdapter implements PatientPort {

    private final JdbcTemplate jdbc;
    public PatientSQLAdapter(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void savePatient(Patient patient) {
        String sql ="INSERT INTO patient (first_name, middle_name, last_name, age, email) VALUES (?, ?,?,?,?)";
        jdbc.update(sql,
                patient.getFirstName(),
                patient.getMiddleName(),
                patient.getLastName(),
                patient.getAge(),
                patient.getEmail());

    }

    @Override
    public Patient findById(Long id) {
        String sql = "SELECT * FROM patient WHERE id = ?";
        return jdbc.queryForObject(sql, new PatientRowMapper(),id);
    }

}
