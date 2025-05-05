package org.jsp.adminbusapi.controller;

import java.util.List;
import org.jsp.adminbusapi.dto.Bus;
import org.jsp.adminbusapi.dto.ResponseStructure;
import org.jsp.adminbusapi.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {
    @Autowired
	private BusService busService;
    
    @PostMapping("/buses/{admin_id}")
	public ResponseEntity<ResponseStructure<Bus>> saveBus(@RequestBody Bus bus,
			@PathVariable int admin_id) {
		return busService.saveBus(bus, admin_id);
	}
	
	@PutMapping("/buses")
	public ResponseEntity<ResponseStructure<Bus>> updateBus(@RequestBody Bus bus) {
		return busService.updateBus(bus);
	}
	
	@GetMapping("/buses/by-bus_number/{bus_number}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByBusNumber(@PathVariable int bus_number){
		return busService.findByBusNumber(bus_number);
	}
	
	@GetMapping("/buses/by-travels_name/{travels_name}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByTravelsName(@PathVariable String travels_name){
		return busService.findByTravelsName(travels_name);
	}
	
	@GetMapping("/buses/by-date_of_departure/{date_of_departure}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByDateOfDeparture(@PathVariable int date_of_departure){
		return busService.findByDateOfDeparture(date_of_departure);
	}
    
	@PostMapping(value="/buses/verify-by-bus")
	public ResponseEntity<ResponseStructure<Bus>> verifyByBus(@RequestParam int date_of_departure,@RequestParam String from_location,@RequestParam String to_location){
		return busService.verifyByBus(date_of_departure, from_location, to_location);
	}
	
	@GetMapping("/buses/by-admin/{admin_id}")
	public ResponseEntity<ResponseStructure<List<Bus>>> findByAdminId(@PathVariable int  admin_id){
		return busService.findByAdminId(admin_id);
	}
}
