package org.jsp.springbootapi.service;

import java.util.List;
import java.util.Optional;
import org.jsp.springbootapi.dao.UserDao;
import org.jsp.springbootapi.dto.ResponseStructure;
import org.jsp.springbootapi.dto.User;
import org.jsp.springbootapi.exception.AgeNotFoundException;
import org.jsp.springbootapi.exception.EmailNotFoundException;
import org.jsp.springbootapi.exception.IdNotFoundException;
import org.jsp.springbootapi.exception.InvalidCredentialsException;
import org.jsp.springbootapi.exception.NameNotFoundException;
import org.jsp.springbootapi.exception.PhoneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.saveUser(user));
		structure.setMessage("User saved Successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.updateUser(user));
		structure.setMessage("User Updated Successfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		Optional<User> dBUser = userDao.findById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dBUser.isPresent()) {
			structure.setData(dBUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setData(userDao.findAll());
		structure.setMessage("List of All Users");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		Optional<User> dBUser = userDao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (dBUser.isPresent()) {
			userDao.delete(id);
			structure.setMessage("User Deleted");
			structure.setData("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setMessage("User Not Deleted");
		structure.setData("User Not Found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone, String password) {
		Optional<User> dBUser = userDao.verifyUser(phone, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dBUser.isPresent()) {
			structure.setData(dBUser.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
//		structure.setMessage(null);
//		structure.setData("Invalid Phone or Password");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
		Optional<User> dBUser = userDao.verifyUser(email, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dBUser.isPresent()) {
			structure.setData(dBUser.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
//		structure.setMessage(null);
//		structure.setData("Invalid Email or Password");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(int id, String password) {
		Optional<User> dBUser = userDao.verifyUser(id, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dBUser.isPresent()) {
			structure.setData(dBUser.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
//		structure.setMessage(null);
//		structure.setData("Invalid Id or Password");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<User>> findUserByPhone(long phone) {
		Optional<User> dBUser = userDao.findUserByPhone(phone);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dBUser.isPresent()) {
			structure.setData(dBUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
//		structure.setData(null);
//		structure.setMessage("User Not Found");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new PhoneNotFoundException();
	}

	public ResponseEntity<ResponseStructure<User>> findUserByEmail(String email) {
		Optional<User> dBUser = userDao.findUserByEmail(email);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (dBUser.isPresent()) {
			structure.setData(dBUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
//		structure.setData(null);
//		structure.setMessage("User Not Found");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new EmailNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> findUserByName(String name) {
		List<User> users = userDao.findUserByName(name);
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		if (users.size()>0) {
			structure.setData(users);
			structure.setMessage("List of users");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
		}
//		structure.setData(null);
//		structure.setMessage("User Not Found");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.NOT_FOUND);	
        throw new NameNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> findUserByAge(int age) {
		List<User> users = userDao.findUserByAge(age);
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		if (users.size()>0) {
			structure.setData(users);
			structure.setMessage("List of users");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
		}
//		structure.setData(null);
//		structure.setMessage("User Not Found");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.NOT_FOUND);	
		throw new AgeNotFoundException();
	}
}
