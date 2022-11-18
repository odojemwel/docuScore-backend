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

import com.docuscore.docs.Entity.ClassEntity;
import com.docuscore.docs.Service.ClassService;

@RestController
@RequestMapping("/Class")
public class ClassController {
	
	@Autowired
	ClassService clserv;
	
	
	//Create
	@PostMapping("/postClass")
	public ClassEntity insertClass(@RequestBody ClassEntity Class) {
		return clserv.insertClass(Class);
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
}