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
import com.docuscore.docs.Entity.TeacherEntity;
import com.docuscore.docs.Service.ClassService;
import com.docuscore.docs.Service.TeacherService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService tserv;
	@Autowired
	ClassService clserv;
	
	//Create
	@PostMapping("/postTeacher")
	public TeacherEntity createTeacher(@RequestBody TeacherEntity teacher) {
		return tserv.createTeacher(teacher);
	}
	
	//Read
	@GetMapping("/getAllTeacher")
	public List<TeacherEntity> getAllTeacher(){
		return tserv.getAllTeacher();
	}
	
	//Update
	@PutMapping("/putTeacher")
	public TeacherEntity putTeacher(@RequestParam int teacherId, @RequestBody TeacherEntity newTeacher) throws Exception{
		return tserv.putTeacher(teacherId, newTeacher);
	}
	
	
	//Delete
	@DeleteMapping("/deleteTeacher/{teacherId}")
	public String deleteTeacher(@PathVariable int teacherId) {
		return tserv.deleteTeacher(teacherId);
	}
	
	//getTeacherByID
	@GetMapping("/getTeacherById")
	public TeacherEntity getTeacherById(@RequestParam int teacherId) {
		return tserv.getTeacherById(teacherId);
	}
	
	//get All Classes By Teacher
	@GetMapping("/classes")
	public List<ClassEntity> getClassByTeacher(@RequestParam int teacherId, @RequestParam boolean isDeleted){
		TeacherEntity teacher = tserv.getTeacherById(teacherId);
		return clserv.getClassByTeacherAndIsDeleted(teacher, isDeleted);
	}
	
	//get Teacher By Employee ID and Password (LOGIN)
	@GetMapping("/login")
	public TeacherEntity login(@RequestParam String employeeId, @RequestParam String password) {
		return tserv.login(employeeId, password);
	}
	
	
}
