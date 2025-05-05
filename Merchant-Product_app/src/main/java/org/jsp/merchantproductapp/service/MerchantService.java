package org.jsp.merchantproductapp.service;

import java.util.Optional;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.ResponseStructure;
import org.jsp.merchantproductapp.exception.MerchantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(merchantDao.saveMerchant(merchant));
		structure.setMessage("Merchant Saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> recMerchant = merchantDao.findById(merchant.getId());
		if (recMerchant.isPresent()) {
			Merchant dbMerchant = recMerchant.get();
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setName(merchant.getName());
			dbMerchant.setPassword(merchant.getPassword());
			dbMerchant.setPhone(merchant.getPhone());
			structure.setData(merchantDao.saveMerchant(dbMerchant));
			structure.setMessage("Merchant Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
		}
		throw new MerchantNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> findMerchantById(int id) {
		Optional<Merchant> dBMerchant = merchantDao.findById(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (dBMerchant.isPresent()) {
			structure.setData(dBMerchant.get());
			structure.setMessage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new MerchantNotFoundException();
	}	
	
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(long phone, String password) {
		Optional<Merchant> dBMerchant = merchantDao.verifyMerchant(phone, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (dBMerchant.isPresent()) {
			structure.setData(dBMerchant.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
//		structure.setMessage(null);
//		structure.setData("Invalid Phone or Password");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new MerchantNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(String email, String password) {
		Optional<Merchant> dBMerchant = merchantDao.verifyMerchant(email, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (dBMerchant.isPresent()) {
			structure.setData(dBMerchant.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
//		structure.setMessage(null);
//		structure.setData("Invalid Email or Password");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new MerchantNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(int id, String password) {
		Optional<Merchant> dBMerchant = merchantDao.verifyMerchant(id, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (dBMerchant.isPresent()) {
			structure.setData(dBMerchant.get());
			structure.setMessage("Verification Successful");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
//		structure.setMessage(null);
//		structure.setData("Invalid Id or Password");
//		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		throw new MerchantNotFoundException();
	}

}
