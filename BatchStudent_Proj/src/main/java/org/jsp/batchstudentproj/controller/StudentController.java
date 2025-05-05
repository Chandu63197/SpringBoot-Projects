package org.jsp.batchstudentproj.controller;

import java.util.List;

import org.jsp.batchstudentproj.dto.Batch;
import org.jsp.batchstudentproj.dto.ResponseStructure;
import org.jsp.batchstudentproj.dto.Student;
import org.jsp.batchstudentproj.service.BatchService;
import org.jsp.batchstudentproj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
    private StudentService studentService;
	
	@PostMapping("/students/{batch_id}")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student,@PathVariable int batch_id){
		return studentService.saveStudent(student,batch_id);
	}
	
	@PutMapping("/students/{batch_id}")
	public ResponseEntity<ResponseStructure<Student>> updateBatch(@RequestBody Student  student,@PathVariable int batch_id){
		return studentService.updateStudent(student, batch_id);
	}
	
	@GetMapping("students/find-by-batch/{batch_id}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchId(@PathVariable int batch_id){
		return studentService.findByBatchId(batch_id);
	}
	
	@GetMapping("students/find-by-code/{batchcode}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchCode(@PathVariable String batchcode){
		return studentService.findByBatchCode(batchcode);
	}
	
	@GetMapping("students/find-by-trainer/{trainer}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByTrainer(@PathVariable String trainer){
		return studentService.findByTrainer(trainer);
	}
	
	@GetMapping("students/find-by-subject/{subject}")
	public ResponseEntity<ResponseStructure<List<Student>>> findBySubject(@PathVariable String subject){
		return studentService.findBySubject(subject);
	}
}
