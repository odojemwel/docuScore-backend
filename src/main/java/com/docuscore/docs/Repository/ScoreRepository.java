package com.docuscore.docs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docuscore.docs.Entity.ExamEntity;
import com.docuscore.docs.Entity.ScoreEntity;
import com.docuscore.docs.Entity.StudentEntity;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer>{

	ScoreEntity findByExamAndStudent(ExamEntity exam, StudentEntity student);
}
