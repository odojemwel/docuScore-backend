package com.docuscore.docs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docuscore.docs.Entity.ClassEntity;
import com.docuscore.docs.Entity.ExamEntity;
import com.docuscore.docs.Entity.TeacherEntity;
import com.docuscore.docs.Service.ClassService;
import com.docuscore.docs.Service.ExamService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Exam")
@CrossOrigin("http://localhost:3000")
public class ExamController {

	@Autowired
	ExamService eserv;
	@Autowired
	ClassService clserv;
	
	//C
	@PostMapping("/postExam")
	public ExamEntity createExam(@RequestBody ExamEntity exam) {
		return eserv.createExam(exam);
	}
	
	//R
	@GetMapping("/getAllExam")
	public List<ExamEntity> getAllExam(){
		return eserv.getAllExam();
		
	}
	
	//U
	@PutMapping("/putExam")
	public ExamEntity putExam(@RequestParam int examId, @RequestBody ExamEntity newExam) throws Exception{
		return eserv.putExam(examId, newExam);
		
	}
	
	
	//D
	@DeleteMapping("/deleteExam/{examId}")
	public String deleteExam(@PathVariable int examId) {
		return eserv.deleteExam(examId);
	}
	
	//get All Exams By Classes
	@GetMapping("/exam/{classId}")
	public List<ExamEntity> getExamByClass(@PathVariable int classId){
		ClassEntity classes = clserv.getClassById(classId);
		return eserv.getExamByClass(classes);
	}
	@GetMapping("/getExamById")
	public ExamEntity getExamById(@RequestParam int examId) {
		return eserv.getExamById(examId);
	}

		
}
