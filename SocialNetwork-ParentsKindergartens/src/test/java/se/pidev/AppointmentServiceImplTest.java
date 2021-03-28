package se.pidev;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import se.pidev.entities.Appointment;
import se.pidev.entities.Appointment_Place;
import se.pidev.entities.Appoitnment_Type;
import se.pidev.services.AppointmentService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceImplTest {
	
	
	@SuppressWarnings("unused")
	private static final Logger l = LogManager.getLogger(AppointmentServiceImplTest.class);
	
	@Autowired
	AppointmentService appS ;
	
	@Test
	public void testAddAppoinment() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2020-01-02");
		Appointment appoinment = new Appointment(12, "Nothing", date, Appointment_Place.ADMINISTRATION_OFFICE, Appoitnment_Type.FINANCIAL);
		assertTrue(appoinment.getAppoitnment_place().equals(Appointment_Place.ADMINISTRATION_OFFICE));
		assertTrue(appoinment.getAppoitnment_type().equals(Appoitnment_Type.FINANCIAL));
		appS.addAppoinment( appoinment);
		
	}
	
	@Test
	public void testRetrieveAppoinment(){
		appS.retrieveAppoinment("5");
	}
	@Test
	public void testRetrieveAllAppoinments(){
		appS.retrieveAllAppoinments();
	}
	@Test
	public void testDeleteAppoinment(){
		appS.deleteAppoinment("4");
	}
	@Test
	public void testUpdateUser() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("2021-03-07");
		Appointment appoinment = new Appointment(3, "About Medical Status of Kids", date, Appointment_Place.DOCTOR_OFFICE, Appoitnment_Type.MEDICAL);
		appS.updateAppoinment(appoinment);
	}
	
	

}
