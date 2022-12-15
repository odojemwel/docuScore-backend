package com.docuscore.docs.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
	public ScoreEntity getScore(ExamEntity examId, StudentEntity studentId) {
		return screpo.findByExamAndStudent(examId, studentId);
//		return screpo.findByExamIDAndStudentID(examId, studentId);
	}
	
	//get score by exam id and class_id order by student last name
	public List<ScoreEntity> getByClassAndExam(int classId, int examId){
		return screpo.findByClassAndExam(classId, examId);
	}
	
	//get score by student_id order by exam_id
	public List<ScoreEntity> getByStudent(int studentId){
		return screpo.findByStudentId(studentId);
	}
	
	
	//update Score
	public ScoreEntity putScore(int scoreId, ScoreEntity newScore) throws Exception{
		ScoreEntity score = new ScoreEntity();
		try {
			score = screpo.findById(scoreId).get();
			score.setValue(newScore.getValue());
			return screpo.save(score);
		}catch(NoSuchElementException e) {
			throw new Exception("Score with ID "+scoreId+" does not exist" );
		}
	}
	
	//delete Score
	public String deleteScore(int scoreId) {
		String msg;
		if(screpo.findById(scoreId).orElse(null) != null) {
			screpo.deleteById(scoreId);
			msg = "Score with ID: "+scoreId+" is deleted!";
		}else {
			msg = "Score with ID: "+scoreId+" does not exist!";
		}
		return msg;
	}
	
	
}
