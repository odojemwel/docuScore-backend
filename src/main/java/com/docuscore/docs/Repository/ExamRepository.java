package com.docuscore.docs.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docuscore.docs.Entity.ClassEntity;
import com.docuscore.docs.Entity.ExamEntity;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Integer>{
	ExamEntity findByExamId(int examId);
	List<ExamEntity> findByClassId(ClassEntity classId);
}
