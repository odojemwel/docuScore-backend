package com.docuscore.docs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docuscore.docs.Entity.ClassEntity;
import com.docuscore.docs.Entity.TeacherEntity;
import com.docuscore.docs.Repository.ClassRepository;

@Service
public class ClassService {

	@Autowired
	ClassRepository crepo;
	
	//Create
	public ClassEntity createClass(ClassEntity newClass) {
		return crepo.save(newClass);
	}
	
	//Read
	public List<ClassEntity> getAllClass(){
		return crepo.findAll();
	}
	
	//Update
	public ClassEntity putClass(int classId, ClassEntity newClass) throws Exception{
		ClassEntity class_entity  = new ClassEntity();
		try {
			class_entity = crepo.findById(classId).get();
			class_entity.setSubject(newClass.getSubject());
			class_entity.setYearLevel(newClass.getYearLevel());
			class_entity.setSection(newClass.getSection());
			class_entity.setActive(newClass.isActive());
			return crepo.save(class_entity);
		}catch(NoSuchElementException e) {
			throw new Exception("Class with ID " +classId+ " does not exist.");
		}
	}
	
	//Delete
	public String deleteClass(int classId) {
		String msg;
		if(crepo.findById(classId) != null) {
			crepo.deleteById(classId);
			msg = "Class with ID " +classId+ "is deleted!";
		}else {
			msg = "Class with ID " +classId+ "does not exist!";
		}
		return msg;
	}
	
	
	//findClassesByTeacherID
	public List<ClassEntity> getClassByTeacher(TeacherEntity teacher){
		List<ClassEntity> classes = crepo.findByTeacher(teacher);
		if(classes != null) {
			return classes;
		}else
			return null;
	}
}