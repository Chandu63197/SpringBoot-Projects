package org.jsp.springbootapi.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootapi.dto.User;
import org.jsp.springbootapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
    private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}
	
	public Optional<User> findById(int id){
		return repository.findById(id);
	}
	
	public List<User> findAll(){
		return repository.findAll();
    }
	
	public boolean delete(int id) {
		Optional<User> dBUser=findById(id);
		if(dBUser.isPresent()) {
			repository.delete(dBUser.get());
			return true;
		}
		return false;
	}
	
	public Optional<User> verifyUser(long phone,String password){
		return repository.verifyUser(phone, password);
	}
	
	public Optional<User> verifyUser(String email,String password){
		return repository.verifyUser(email, password);
	}
	
	public Optional<User> verifyUser(int id,String password){
		return repository.verifyUser(id, password);
	}
	
	public Optional<User> findUserByPhone(long phone){
		return repository.findUserByPhone(phone);
	}
	
	public Optional<User> findUserByEmail(String email){
		return repository.findUserByEmail(email);
	}
	
	public List<User> findUserByName(String name){
		return repository.findUserByName(name);
	}

	public List<User> findUserByAge(int age){
		return repository.findUserByAge(age);
	}
}
