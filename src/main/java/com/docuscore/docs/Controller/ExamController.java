package com.docuscore.docs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docuscore.docs.Entity.ExamEntity;
import com.docuscore.docs.Service.ExamService;

@RestController
@RequestMapping("/Exam")
public class ExamController {

	@Autowired
	ExamService eserv;
	
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
	public ExamEntity putExam(@RequestParam int ExamId, @RequestBody ExamEntity newExam) throws Exception{
		return eserv.putExam(ExamId, newExam);
	}
	
	
	//D
	@DeleteMapping("/deleteExam/{id}")
	public String deleteExam(@PathVariable int ExamId) {
		return eserv.deleteExam(ExamId);
	}
	
}
