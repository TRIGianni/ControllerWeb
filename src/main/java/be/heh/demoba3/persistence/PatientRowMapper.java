package be.heh.demoba3.persistence;

import be.heh.demoba3.model.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PatientRowMapper implements RowMapper<Patient> {
    @Override
    public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Patient(rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("middle_name"),
                rs.getString("last_name"),
                rs.getInt("age"),
                rs.getString("email"),
                rs.getString("blood_type"),
                rs.getBoolean("consent_given"),
                rs.getInt("policy_number"),
                rs.getObject("registration_date", LocalDate.class),
                //rs.getDate("registration_date").toLocalDate(),
                rs.getObject("date_of_birth", LocalDate.class),
                //rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("insurer_id"),
                rs.getString("ssn")
                );
    }
}
