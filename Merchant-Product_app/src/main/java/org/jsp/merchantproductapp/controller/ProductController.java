package org.jsp.merchantproductapp.controller;

import java.util.List;

import org.jsp.merchantproductapp.dto.Product;
import org.jsp.merchantproductapp.dto.ResponseStructure;
import org.jsp.merchantproductapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  @CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/products/{merchant_id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,
			@PathVariable int merchant_id) {
		return productService.saveProduct(product, merchant_id);
	}
	
	@PutMapping("/products")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Product>> findProductById(@PathVariable int id) {
		return productService.findById(id);
	}
	
	@GetMapping("/products/by-brand/{brand}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByBrand(@PathVariable String brand){
		return productService.findByBrand(brand);
	}
	
	@GetMapping("/products/by-category/{category}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByCategory(@PathVariable String category){
		return productService.findByCategory(category);
	}
	
	@GetMapping("/products/by-merchant/{merchant_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> findByMerchantId(@PathVariable int  merchant_id){
		return productService.findByMerchantId(merchant_id);
	}
	
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
		return productService.findAll();
    }
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int id){
		return productService.deleteProduct(id);
	}


}
