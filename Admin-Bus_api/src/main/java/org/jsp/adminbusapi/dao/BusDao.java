package org.jsp.adminbusapi.dao;

import java.util.List;
import java.util.Optional;
import org.jsp.adminbusapi.dto.Bus;
import org.jsp.adminbusapi.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {
	@Autowired
 	private BusRepository busRepository;
	
	public Bus saveBus(Bus bus) {
		return busRepository.save(bus);
	}
	
	public Optional<Bus> findById(int id){
		return busRepository.findById(id);
	}
	
	public List<Bus> findByBusNumber(int  bus_number){
		return busRepository.findByBusNumber(bus_number);
	}
	
	public List<Bus> findByDateOfDeparture(int  date_of_departure){
		return busRepository.findByDateOfDeparture(date_of_departure);
	}
	
	public List<Bus> findByAdminId(int id){
		return busRepository.findByAdminId(id);
	}
	
	public List<Bus> findByTravelsName(String travels_name){
		return busRepository.findByTravelsName(travels_name);
	}
	
	public Optional<Bus> verifyByBus(int date_of_departure,String from_location,String to_location){
		return busRepository.verifyByBus(date_of_departure, from_location, to_location);
	}
}
