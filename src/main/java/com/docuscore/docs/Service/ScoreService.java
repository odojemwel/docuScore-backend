package com.docuscore.docs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docuscore.docs.Entity.ExamEntity;
import com.docuscore.docs.Entity.ScoreEntity;
import com.docuscore.docs.Entity.StudentEntity;
import com.docuscore.docs.Repository.ScoreRepository;

@Service
public class ScoreService {
	
	@Autowired
	ScoreRepository screpo;

	//create Score
	public ScoreEntity createScore(ScoreEntity score) {
		return screpo.save(score);
	}
	
	//get Score by Exam and Student
	public ScoreEntity getScore(ExamEntity exam, StudentEntity student) {
		return screpo.findByExamAndStudent(exam, student);
	}
	
}
