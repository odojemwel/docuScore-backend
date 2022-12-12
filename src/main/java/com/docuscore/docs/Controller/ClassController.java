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
@RequestMapping("/Class")
public class ClassController {
	
	@Autowired
	ClassService clserv;
	ExamService eserv;
	
	
	//Create
	@PostMapping("/postClass")
	public ClassEntity createClass(@RequestBody ClassEntity Class) {
		return clserv.createClass(Class);
	}
	
	//Read all
	@GetMapping("/getAllClass")
	public List<ClassEntity> getAllClasss(){
		return clserv.getAllClass();
	} 
	
	//Update
	@PutMapping("/putClass")
	public ClassEntity putClass(@RequestParam int id,@RequestBody ClassEntity newClassDetails) throws Exception {
		return clserv.putClass(id, newClassDetails);
	}
	
	//Delete
	@DeleteMapping("/deleteClass/{id}")
	public String deleteClass(@PathVariable int id) {
		return clserv.deleteClass(id);

	}	


	//get All Classes By Class
	@GetMapping("/getClassbyId/{classId}")
	public ClassEntity getClassById(@PathVariable int classId){
		return clserv.getClassById(classId);
	}
}
	

