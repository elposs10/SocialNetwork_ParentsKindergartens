package se.pidev.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.pidev.entities.Appointment;
import se.pidev.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	AppointmentRepository appointmentRepository ;

private static final Logger l = LogManager.getLogger(AppointmentServiceImpl.class);
	

	@Override
	public List<Appointment> retrieveAllAppoinments() {
		List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
		for (Appointment appointment : appointments){
			l.info("appoinment +++ : " + appointment);
		}
		return appointments ;
	}

	@Override
	public Appointment addAppoinment(Appointment app) {
		return appointmentRepository.save(app);
	}

	@Override
	public void deleteAppoinment(String id) {
			appointmentRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Appointment updateAppoinment(Appointment app) {
		return appointmentRepository.save(app);
	}

	@Override
	public Appointment retrieveAppoinment(String id) {
		 Appointment appoi = appointmentRepository.findById(Long.parseLong(id)).get();
		l.info("appoinment returned :" + appoi);
		 return appoi;
	}

}
