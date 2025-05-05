package org.jsp.adminbusapi.service;

import java.util.Optional;
import org.jsp.adminbusapi.dao.AdminDao;
import org.jsp.adminbusapi.dto.Admin;
import org.jsp.adminbusapi.dto.ResponseStructure;
import org.jsp.adminbusapi.exception.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
    private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setData(adminDao.saveAdmin(admin));
		structure.setMessage("Admin Saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin){
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=adminDao.findById(admin.getId());
		if(recAdmin.isPresent()) {
			Admin dBAdmin=recAdmin.get();
			dBAdmin.setName(admin.getName());
			dBAdmin.setEmail(admin.getEmail());
			dBAdmin.setPhone(admin.getPhone());
			dBAdmin.setPassword(admin.getPassword());
			dBAdmin.setGst(admin.getGst());
			dBAdmin.setTravels_name(admin.getTravels_name());
            structure.setData(adminDao.saveAdmin(dBAdmin));
            structure.setMessage("Admin Updated");
            structure.setStatusCode(HttpStatus.ACCEPTED.value());
            return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.ACCEPTED);
		}
		throw new AdminNotFoundException("Invalid Id");
	}
	
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(int id) {
		Optional<Admin> dBAdmin = adminDao.findById(id);
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (dBAdmin.isPresent()) {
			structure.setData(dBAdmin.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFoundException("Invalid Id");
	}	
	
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(long phone, String password) {
		Optional<Admin> dBAdmin = adminDao.verifyAdmin(phone, password);
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (dBAdmin.isPresent()) {
			structure.setData(dBAdmin.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
//		structure.setMessage(null);
//		structure.setData("Invalid Phone or Password");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new AdminNotFoundException("Invalid Phone or Password");
	}
	
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(String email, String password) {
		Optional<Admin> dBAdmin = adminDao.verifyAdmin(email, password);
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		if (dBAdmin.isPresent()) {
			structure.setData(dBAdmin.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
//		structure.setMessage(null);
//		structure.setData("Invalid Email or Password");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new AdminNotFoundException("Invalid Email or Password");
	}

}
