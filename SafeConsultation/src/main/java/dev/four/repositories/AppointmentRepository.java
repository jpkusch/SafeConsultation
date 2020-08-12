package dev.four.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.four.entities.Appointment;

@Component
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	
}
