package se.pidev.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.pidev.entities.Appointment;
import se.pidev.services.AppointmentServiceImpl;



@RestController
public class AppintmentRestController {
	
	@Autowired
	private AppointmentServiceImpl serviceAppointment ;
	
	//save an Appoinment 
	
	@PostMapping(value = "/addAppoinment")
	public Appointment addAppoinment(@RequestBody Appointment appoinment){
		System.out.println("Appoinment added jawou behi .....");
		serviceAppointment.addAppoinment(appoinment);
		return appoinment;
	}
	
	
	//find all Appoinments
	
	@GetMapping(value = "/getAppoinment")
	public List<Appointment> findAllAppoinment(){
		List<Appointment> list = serviceAppointment.retrieveAllAppoinments();
		return list;
	}
	
	
	//UpdateAppoinments
	
	
	@PutMapping(value = "/updateAppoinment")
	public Appointment updateAppoinment(@RequestBody Appointment appoinment){
		return serviceAppointment.updateAppoinment(appoinment);
		
	}
	
	// delete an Appoinment
	
	@DeleteMapping("deleteAppoinment")
	public String deleteAppoinment(@RequestParam String id){
		
		serviceAppointment.deleteAppoinment(id);
		return "Appoinment Deleted";
		
	}
	
	// findOneAppoinment
	@GetMapping(value = "/get-Appoinment/{Appoinment-id}")
	@ResponseBody
	public Appointment findAppoinment(@PathVariable("Appoinment-id") String Id){
		return serviceAppointment.retrieveAppoinment(Id);
		
	}

}
