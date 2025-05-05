package org.jsp.batchstudentproj.repository;

import java.util.List;

import org.jsp.batchstudentproj.dto.Batch;
import org.jsp.batchstudentproj.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("select b.students from Batch b where b.trainer=?1")
	public List<Student> findByTrainer(String trainer);

	@Query("select b.students from Batch b where b.batchcode=?1")
	public List<Student> findByBatchCode(String batchcode);

	@Query("select b.students from Batch b where b.subject=?1")
	public List<Student> findBySubject(String subject);

	@Query("select b.students from Batch b where b.id=?1")
	public List<Student> findByBatchId(int id);
}
