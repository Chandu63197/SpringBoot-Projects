package org.jsp.merchantproductapp.controller;

import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.ResponseStructure;
import org.jsp.merchantproductapp.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @CrossOrigin
public class MerchantController {
	@Autowired
	private MerchantService merchantService;

	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
		return merchantService.saveMerchant(merchant);
	}

	@PutMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return merchantService.updateMerchant(merchant);
	}
	
	@GetMapping("/merchants/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> findAdminById(@PathVariable int id) {
		return merchantService.findMerchantById(id);
	}
	
	@PostMapping(value="/merchants/verify-by-phone")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam long phone,@RequestParam String password){
		return merchantService.verifyMerchant(phone, password);
	}
	
	@PostMapping(value="/merchants/verify-by-email")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam String email,@RequestParam String password){
		return merchantService.verifyMerchant(email, password);
	}

	@PostMapping(value="/merchants/verify-by-id")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam int id,@RequestParam String password){
		return merchantService.verifyMerchant(id, password);
	}

}
