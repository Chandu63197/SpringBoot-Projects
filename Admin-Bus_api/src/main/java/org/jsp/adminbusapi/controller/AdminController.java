package org.jsp.adminbusapi.controller;

import org.jsp.adminbusapi.dto.Admin;
import org.jsp.adminbusapi.dto.ResponseStructure;
import org.jsp.adminbusapi.service.AdminService;
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
public class AdminController {
	@Autowired
    private AdminService adminService;
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	
	@GetMapping("/admins/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@PathVariable int id) {
		return adminService.findAdminById(id);
	}
	
	@PostMapping(value="/admins/verify-by-phone")
	public ResponseEntity<ResponseStructure<Admin>> verifyUser(@RequestParam long phone,@RequestParam String password){
		return adminService.verifyAdmin(phone, password);
	}
	
	@PostMapping(value="/admins/verify-by-email")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(@RequestParam String email,@RequestParam String password){
		return adminService.verifyAdmin(email, password);
	}

}
