package se.pidev.services;

import java.util.List;

import se.pidev.entities.Appointment;


public interface AppointmentService {
	
	List<Appointment> retrieveAllAppoinments();
	Appointment addAppoinment(Appointment app);
	void deleteAppoinment(String id);
	Appointment updateAppoinment(Appointment app);
	Appointment retrieveAppoinment(String id);

}
