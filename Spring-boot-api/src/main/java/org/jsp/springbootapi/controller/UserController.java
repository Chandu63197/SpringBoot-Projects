package org.jsp.springbootapi.controller;

import java.util.List;
import org.jsp.springbootapi.dto.ResponseStructure;
import org.jsp.springbootapi.dto.User;
import org.jsp.springbootapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(value = "/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PutMapping(value="/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id) {
		return service.findUserById(id);
	}
	
	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		return service.findAll();
    }
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id){
		return service.deleteUser(id);
	}
	
	@PostMapping(value="/users/verify-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone,@RequestParam String password){
		return service.verifyUser(phone, password);
	}
	
	@PostMapping(value="/users/verify-by-email")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email,@RequestParam String password){
		return service.verifyUser(email, password);
	}

	@PostMapping(value="/users/verify-by-id")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam int id,@RequestParam String password){
		return service.verifyUser(id, password);
	}
	
	@GetMapping("/users/find-by-name")
	public ResponseEntity<ResponseStructure<List<User>>> findUserByName(@RequestParam String name){
		return service.findUserByName(name);
	}
	
	@GetMapping("/users/find-by-age")
	public ResponseEntity<ResponseStructure<List<User>>> findUserByAge(@RequestParam int age){
		return service.findUserByAge(age);
	}
	
	@GetMapping("/users/find-by-email")
	public ResponseEntity<ResponseStructure<User>> findUserByEmail(@RequestParam String email){
		return service.findUserByEmail(email);
	}
	
	@GetMapping("/users/find-by-phone")
	public ResponseEntity<ResponseStructure<User>> findUserByPhone(@RequestParam long phone){
		return service.findUserByPhone(phone);
	}

}
