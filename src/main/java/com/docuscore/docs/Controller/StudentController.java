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

import com.docuscore.docs.Entity.StudentEntity;
import com.docuscore.docs.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService stserv;
	
	
	//Create
	@PostMapping("/postStudent")
	public StudentEntity insertStudent(@RequestBody StudentEntity student) {
		return stserv.insertStudent(student);
	}
	
	//Read all
	@GetMapping("/getAllStudents")
	public List<StudentEntity> getAllStudents(){
		return stserv.getAllStudents();
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
