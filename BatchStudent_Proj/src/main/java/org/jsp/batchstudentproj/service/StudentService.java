package org.jsp.batchstudentproj.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.jsp.batchstudentproj.dao.BatchDao;
import org.jsp.batchstudentproj.dao.StudentDao;
import org.jsp.batchstudentproj.dto.Batch;
import org.jsp.batchstudentproj.dto.ResponseStructure;
import org.jsp.batchstudentproj.dto.Student;
import org.jsp.batchstudentproj.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private BatchDao batchDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student,int batch_id){
		ResponseStructure<Student> structure=new ResponseStructure<>();
		Optional<Batch> dBBatch=batchDao.findById(batch_id);
		if(dBBatch.isPresent()) {
			Batch batch=dBBatch.get();
			batch.getStudents().add(student);
			List<Batch> batches=student.getBatches();
			if(batches==null) {
				student.setBatches(new ArrayList<>(Arrays.asList(batch)));
			}
		    student.getBatches().add(batch);
		    batchDao.saveBatch(batch);
		    structure.setData(studentDao.saveStudent(student));
		    structure.setMessage("Student Added");
		    structure.setStatusCode(HttpStatus.CREATED.value());
		    return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
		}
		throw new StudentNotFoundException("Invalid Batch Id");
	}
    
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student,int batch_id){
		ResponseStructure<Student> structure=new ResponseStructure<>();
		Optional<Batch> dBBatch=batchDao.findById(batch_id);
		Optional<Student> recStudent=studentDao.findById(student.getId());
		if(recStudent.isPresent()) {
			Batch batch=dBBatch.get();
			Student dBStudent=recStudent.get();
		    dBStudent.setName(student.getName());
		    dBStudent.setPhone(student.getPhone());
		    dBStudent.setAge(student.getAge());
		    dBStudent.setPercentage(student.getPercentage());
		    List<Batch> batches=student.getBatches();
			if(batches==null) {
				student.setBatches(new ArrayList<>(Arrays.asList(batch)));
			}
		    student.getBatches().add(batch);
		    structure.setData(studentDao.saveStudent(student));
		    structure.setMessage("Student updated");
		    structure.setStatusCode(HttpStatus.ACCEPTED.value());
		    return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
		}
		throw new StudentNotFoundException("Invalid Student Id");

	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchId(int batch_id) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> recStudent = studentDao.findByBatchId(batch_id);
		if (recStudent.size() > 0) {
			structure.setData(recStudent);
			structure.setMessage("Batch Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException("Invalid Batch Id");
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByTrainer(String batch_trainer) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> recBatch = studentDao.findByTrainer(batch_trainer);
		if (recBatch.size() > 0) {
			structure.setData(recBatch);
			structure.setMessage("Student Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException("Invalid Trainer");
	}

	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchCode(String batch_batchcode) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> recBatch = studentDao.findByBatchCode(batch_batchcode);
		if (recBatch.size() > 0) {
			structure.setData(recBatch);
			structure.setMessage("Student Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException("Invalid BatchCode");
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findBySubject(String batch_subject) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> recBatch = studentDao.findBySubject(batch_subject);
		if (recBatch.size() > 0) {
			structure.setData(recBatch);
			structure.setMessage("Student Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException("Invalid Subject");
	}

}
