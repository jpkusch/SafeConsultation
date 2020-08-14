package dev.four.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.four.entities.Doctor;

@Component
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	
	List<Doctor> findByUsername(String username);
	

	
}
