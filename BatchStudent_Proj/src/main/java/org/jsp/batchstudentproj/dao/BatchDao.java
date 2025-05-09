package org.jsp.batchstudentproj.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.batchstudentproj.dto.Batch;
import org.jsp.batchstudentproj.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BatchDao {
	@Autowired
    private BatchRepository batchRepository;
	
	public Batch saveBatch(Batch batch) {
		return batchRepository.save(batch);
	}
	
	public Optional<Batch> findById(int id) {
		return batchRepository.findById(id);
	}
	
	public List<Batch> findByPhone(long phone){
		return batchRepository.findByPhone(phone);
	}
	
	public List<Batch> findByStudentId(int id){
		return batchRepository.findByStudentId(id);
	}
}
