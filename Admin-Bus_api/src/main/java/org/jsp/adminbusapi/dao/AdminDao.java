package org.jsp.adminbusapi.dao;

import java.util.Optional;
import org.jsp.adminbusapi.dto.Admin;
import org.jsp.adminbusapi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
    private AdminRepository adminRepository;
    
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Optional<Admin> findById(int id){
		return adminRepository.findById(id);
	}
	
	public Optional<Admin> verifyAdmin(long phone,String password){
		return adminRepository.verifyAdmin(phone, password);
	}
	
	public Optional<Admin> verifyAdmin(String email,String password){
		return adminRepository.verifyAdmin(email, password);
	}
}
