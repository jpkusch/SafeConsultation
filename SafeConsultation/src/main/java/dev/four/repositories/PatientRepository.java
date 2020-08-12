package dev.four.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.four.entities.Patient;

@Component
@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
