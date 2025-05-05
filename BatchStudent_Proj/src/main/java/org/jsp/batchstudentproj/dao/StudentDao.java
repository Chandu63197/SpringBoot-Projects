package org.jsp.batchstudentproj.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.batchstudentproj.dto.Student;
import org.jsp.batchstudentproj.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	@Autowired
    private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Optional<Student> findById(int id){
		return studentRepository.findById(id);
	}
	
	public List<Student> findByBatchCode(String batchcode){
		return studentRepository.findByBatchCode(batchcode);
	}
		
	public List<Student> findBySubject(String subject){
		return studentRepository.findBySubject(subject);
	}
	
	public List<Student> findByTrainer(String trainer){
		return studentRepository.findByTrainer(trainer);
	}
	
	public List<Student> findByBatchId(int id){
		return studentRepository.findByBatchId(id);
	}
}
