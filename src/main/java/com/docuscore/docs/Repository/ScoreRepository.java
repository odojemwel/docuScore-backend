package com.docuscore.docs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.docuscore.docs.Entity.ExamEntity;
import com.docuscore.docs.Entity.ScoreEntity;
import com.docuscore.docs.Entity.StudentEntity;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer>{

//	@Query(
//			value = "SELECT * FROM tbl_score s WHERE s.exam_id = ?1 AND s.student_id = ?2",
//			nativeQuery = true)
	ScoreEntity findByExamAndStudent(ExamEntity exam, StudentEntity student);
//	ScoreEntity findByExamIDAndStudentID(int examId, int studentId);
}
