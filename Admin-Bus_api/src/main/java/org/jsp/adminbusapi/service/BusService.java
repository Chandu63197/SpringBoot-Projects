package org.jsp.adminbusapi.service;

import java.util.List;
import java.util.Optional;
import org.jsp.adminbusapi.dao.AdminDao;
import org.jsp.adminbusapi.dao.BusDao;
import org.jsp.adminbusapi.dto.Admin;
import org.jsp.adminbusapi.dto.Bus;
import org.jsp.adminbusapi.dto.ResponseStructure;
import org.jsp.adminbusapi.exception.AdminNotFoundException;
import org.jsp.adminbusapi.exception.BusNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	@Autowired
    private BusDao busDao;
	@Autowired
	private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Bus>> saveBus(Bus bus, int admin_id) {
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		Optional<Admin> dBAdmin = adminDao.findById(admin_id);
		if (dBAdmin.isPresent()) {
			Admin admin = dBAdmin.get();
			admin.getBus().add(bus);
			bus.setAdmin(admin);
			adminDao.saveAdmin(admin);
			structure.setData(busDao.saveBus(bus));
			structure.setMessage("Bus added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.CREATED);
		}
		throw new AdminNotFoundException("Invalid Admin Id");
	}
	
	public ResponseEntity<ResponseStructure<Bus>> updateBus(Bus bus) {
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		Optional<Bus> recBus = busDao.findById(bus.getId());
		if (recBus.isPresent()) {
			Bus dBBus = recBus.get();
			dBBus.setBus_number(bus.getBus_number());
		    dBBus.setCost_per_seat(bus.getCost_per_seat());
		    dBBus.setDate_of_departure(bus.getDate_of_departure());
		    dBBus.setFrom_location(bus.getFrom_location());
		    dBBus.setTo_location(bus.getTo_location());
		    dBBus.setNo_of_seats(bus.getNo_of_seats());
			structure.setData(busDao.saveBus(dBBus));
			structure.setMessage("Bus Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException("Invalid Bus Id");
	}
	
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findByAdminId(int id){
		ResponseStructure<List<Bus>> structure =new ResponseStructure<>();
		List<Bus> products=busDao.findByAdminId(id);
		if(products.size()>0) {
			structure.setData(products);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure,HttpStatus.OK);
		}
		throw new BusNotFoundException("Invalid Admin Id");
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findByBusNumber(int bus_number){
		ResponseStructure<List<Bus>> structure =new ResponseStructure<>();
		List<Bus> bus=busDao.findByBusNumber(bus_number);
		if(bus.size()>0) {
			structure.setData(bus);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure,HttpStatus.OK);
		}
		throw new BusNotFoundException("Invalid Bus_Number");
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> findByDateOfDeparture(int date_of_departure){
		ResponseStructure<List<Bus>> structure =new ResponseStructure<>();
		List<Bus> bus=busDao.findByDateOfDeparture(date_of_departure);
		if(bus.size()>0) {
			structure.setData(bus);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure,HttpStatus.OK);
		}
		throw new BusNotFoundException("Invalid Date of Departure");
	}

	public ResponseEntity<ResponseStructure<List<Bus>>> findByTravelsName(String travels_name){
		ResponseStructure<List<Bus>> structure =new ResponseStructure<>();
		List<Bus> bus=busDao.findByTravelsName(travels_name);
		if(bus.size()>0) {
			structure.setData(bus);
			structure.setMessage("Buses Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure,HttpStatus.OK);
		}
		throw new BusNotFoundException("Invalid Travels_Name");
	}
    
	public ResponseEntity<ResponseStructure<Bus>> verifyByBus(int date_of_departure,String from_location,String to_location) {
		Optional<Bus> dBBus = busDao.verifyByBus(date_of_departure, from_location, to_location);
		ResponseStructure<Bus> structure = new ResponseStructure<>();
		if (dBBus.isPresent()) {
			structure.setData(dBBus.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.OK);
		}
		throw new BusNotFoundException("Invalid Date_of_Departure,From_Location and To_Location");
	}

}
