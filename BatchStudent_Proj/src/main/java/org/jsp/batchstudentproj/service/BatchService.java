package org.jsp.batchstudentproj.service;

import java.util.List;
import java.util.Optional;
import org.jsp.batchstudentproj.dao.BatchDao;
import org.jsp.batchstudentproj.dto.Batch;
import org.jsp.batchstudentproj.dto.ResponseStructure;
import org.jsp.batchstudentproj.exception.BatchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
    @Autowired
	private BatchDao batchDao;
    
    public ResponseEntity<ResponseStructure<Batch>> saveBatch(Batch batch) {
    	ResponseStructure<Batch> structure=new ResponseStructure<>();
    	structure.setData(batchDao.saveBatch(batch));
    	structure.setMessage("Batch saved");
    	structure.setStatusCode(HttpStatus.CREATED.value());
    	return new ResponseEntity<ResponseStructure<Batch>>(structure,HttpStatus.CREATED);
    }
    
    public ResponseEntity<ResponseStructure<Batch>> updateBatch(Batch batch){
    	ResponseStructure<Batch> structure=new ResponseStructure<>();
    	Optional<Batch> recBatch=batchDao.findById(batch.getId());
    	if(recBatch.isPresent()) {
    		Batch dBBatch=recBatch.get();
    		dBBatch.setBatchcode(batch.getBatchcode());
    		dBBatch.setSubject(batch.getSubject());
    		dBBatch.setTrainer(batch.getTrainer());
    		structure.setData(batchDao.saveBatch(dBBatch));
    		structure.setMessage("Batch Updated");
    		structure.setStatusCode(HttpStatus.ACCEPTED.value());
    		return new ResponseEntity<ResponseStructure<Batch>>(structure,HttpStatus.ACCEPTED);
    	}
    	throw new BatchNotFoundException("Invalid Batch Id");
    }
    
    public ResponseEntity<ResponseStructure<List<Batch>>> findByStudentId(int student_id){
    	ResponseStructure<List<Batch>> structure=new ResponseStructure<>();
    	List<Batch> recBatch=batchDao.findByStudentId(student_id);
        if(recBatch.size()>0) {
        	structure.setData(recBatch);
        	structure.setMessage("Batch Found");
        	structure.setStatusCode(HttpStatus.OK.value());
        	return new ResponseEntity<ResponseStructure<List<Batch>>>(structure,HttpStatus.OK);
        }
        throw new BatchNotFoundException("Invalid Student Id");
    }
    
    public ResponseEntity<ResponseStructure<List<Batch>>> findByPhone(long phone){
    	ResponseStructure<List<Batch>> structure=new ResponseStructure<>();
    	List<Batch> recBatch=batchDao.findByPhone(phone);
        if(recBatch.size()>0) {
        	structure.setData(recBatch);
        	structure.setMessage("Batch Found");
        	structure.setStatusCode(HttpStatus.OK.value());
        	return new ResponseEntity<ResponseStructure<List<Batch>>>(structure,HttpStatus.OK);
        }
        throw new BatchNotFoundException("Invalid Student Phone");
    }
}
