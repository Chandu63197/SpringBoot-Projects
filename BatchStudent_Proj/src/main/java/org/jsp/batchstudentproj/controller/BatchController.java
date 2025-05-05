package org.jsp.batchstudentproj.controller;

import java.util.List;
import org.jsp.batchstudentproj.dto.Batch;
import org.jsp.batchstudentproj.dto.ResponseStructure;
import org.jsp.batchstudentproj.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {
	@Autowired
    private BatchService batchService;
	
	@PostMapping("/batches")
	public ResponseEntity<ResponseStructure<Batch>> saveBatch(@RequestBody Batch batch){
		return batchService.saveBatch(batch);
	}
	
	@PutMapping("/batches")
	public ResponseEntity<ResponseStructure<Batch>> updateBatch(@RequestBody Batch  batch){
		return batchService.saveBatch(batch);
	}
	
	@GetMapping("batches/find-by-id/{id}")
	public ResponseEntity<ResponseStructure<List<Batch>>> findByStudentId(@PathVariable int id){
		return batchService.findByStudentId(id);
	}
	
	@GetMapping("batches/find-by-phone/{phone}")
	public ResponseEntity<ResponseStructure<List<Batch>>> findByStudentPhone(@PathVariable long phone){
		return batchService.findByPhone(phone);
	}
}
