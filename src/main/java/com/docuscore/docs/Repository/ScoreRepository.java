package com.docuscore.docs.Repository;

import java.util.List;

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
	
	//get score by exam id and class_id order by student last name
	@Query(
			value = "SELECT s.exam_id, s.score_id, s.student_id, s.value"
					+ " FROM tbl_score s, tbl_exam e, tbl_student st"
					+ " WHERE s.student_id = st.student_id"
					+ " AND s.exam_id = e.exam_id"
					+ " AND e.exam_id = ?2"
					+ " AND e.class_id = ?1"
					+ " ORDER BY st.last_name;",
			nativeQuery = true
			)
	List<ScoreEntity> findByClassAndExam(int classId, int examId);
	
	@Query(
			value = "SELECT s.score_id, s.value, s.exam_id, s.student_id "
					+ "FROM tbl_score s, tbl_student st "
					+ "WHERE s.student_id = st.student_id "
					+ "AND st.student_id = ?1 "
					+ "ORDER BY s.exam_id",
			nativeQuery = true
			)
	List<ScoreEntity> findByStudentId(int studentId);
}
