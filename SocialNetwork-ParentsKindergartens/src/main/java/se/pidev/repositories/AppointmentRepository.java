package se.pidev.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.pidev.entities.Appointment;


@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
