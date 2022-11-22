package com.docuscore.docs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docuscore.docs.Entity.ExamEntity;
import com.docuscore.docs.Entity.ScoreEntity;
import com.docuscore.docs.Entity.StudentEntity;
import com.docuscore.docs.Service.ExamService;
import com.docuscore.docs.Service.ScoreService;
import com.docuscore.docs.Service.StudentService;

@RestController
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	ScoreService scserv;
	@Autowired
	ExamService exserv;
	@Autowired
	StudentService stserv;
	
	
	@PostMapping("/addScore")
	public ScoreEntity createScore(@RequestBody ScoreEntity score) {
		return scserv.createScore(score);
	}
	
	
	@GetMapping("/getScore") 
	public ScoreEntity getScore(@RequestParam int examId, @RequestParam int studentId) {
//		ExamEntity exam = get Exam by examId
		ExamEntity exam = exserv.getExamById(examId);
//		StudentEntity student = get Student by StudentId
		StudentEntity student = stserv.getStudentById(studentId);
		return scserv.getScore(exam, student);
	}
}
