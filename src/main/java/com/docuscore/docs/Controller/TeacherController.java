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

import com.docuscore.docs.Entity.TeacherEntity;
import com.docuscore.docs.Service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService tserv;
	
	//C
	@PostMapping("/putTeacher")
	public TeacherEntity createTeacher(@RequestBody TeacherEntity teacher) {
		return tserv.createTeacher(teacher);
	}
	
	//R
	@GetMapping("/getAllTeacher")
	public List<TeacherEntity> getAllTeacher(){
		return tserv.getAllTeacher();
	}
	
	//U
	@PutMapping("/putTeacher")
	public TeacherEntity putTeacher(@RequestParam int teacherId, @RequestBody TeacherEntity newTeacher) throws Exception{
		return tserv.putTeacher(teacherId, newTeacher);
	}
	
	
	//D
	@DeleteMapping("/deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable int teacherId) {
		return tserv.deleteTeacher(teacherId);
	}
	
}