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

import com.docuscore.docs.Entity.StudentEntity;
import com.docuscore.docs.Service.ClassService;
import com.docuscore.docs.Service.StudentService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stserv;
	
	@Autowired
	ClassService clserv;
	
	//@Autowired
	//EnrollService eserv;
	
	
	//Create
	@PostMapping("/postStudent")
	public StudentEntity insertStudent(@RequestBody StudentEntity student,@RequestParam int class_id) {
		return stserv.insertStudent(student, class_id);
	}
	
	//Read all
	@GetMapping("/getAllStudents")
	public List<StudentEntity> getAllStudents(){
		return stserv.getAllStudents();
	} 
	

	//Read all Student by StudentId
	@GetMapping("/getStudentsById/{id}")
	public StudentEntity findByStudentId(@PathVariable int id) {
		return stserv.getStudentById(id);
	}
	
	@GetMapping("/getStudentsByClassId")
	public List<StudentEntity> getStudentByClassId(@RequestParam int classId) {
		return stserv.getStudentByClassId(classId);
	}
	
	//Update
	@PutMapping("/putStudent")
	public StudentEntity putStudent(@RequestParam int id,@RequestBody StudentEntity newStudentDetails) throws Exception {
		return stserv.putStudent(id, newStudentDetails);
	}
	
	//Delete
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return stserv.deleteStudent(id);
	}	
}
