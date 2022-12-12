package com.docuscore.docs.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.docuscore.docs.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	StudentEntity findByStudentId(int id);
	
	@Query(
			value="SELECT s.student_id, s.class_number, s.first_name, "
					+ "s.last_name, s.is_deleted, s.stud_school_id "
					+ "FROM tbl_enroll e, tbl_student s "
					+ "WHERE s.student_id = e.student_id "
					+ "AND e.class_id = ?1 "
					+ "ORDER BY s.last_name",
			nativeQuery = true
			)
	List<StudentEntity> findByClassId(int classId);

}
