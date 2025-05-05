package org.jsp.adminbusapi.repository;

import java.util.List;
import java.util.Optional;
import org.jsp.adminbusapi.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository extends JpaRepository<Bus, Integer>{
	@Query("select b from Bus b where b.bus_number=?1")
	public List<Bus> findByBusNumber(int bus_number);

	@Query("select b from Bus b where b.date_of_departure=?1")
	public List<Bus> findByDateOfDeparture(int date_of_departure);

	@Query("select b from Bus b where b.admin.id=?1")
	public List<Bus> findByAdminId(int id);
	
	@Query("select b from Bus b where b.admin.travels_name=?1")
	public List<Bus> findByTravelsName(String travels_name);
	
	@Query("select b from Bus b where b.date_of_departure=?1 and b.from_location=?2 and b.to_location=?3")
    public Optional<Bus> verifyByBus(int date_of_departure,String from_location,String to_location);

}
