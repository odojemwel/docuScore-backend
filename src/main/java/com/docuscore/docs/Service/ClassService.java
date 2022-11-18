package com.docuscore.docs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docuscore.docs.Entity.ClassEntity;
import com.docuscore.docs.Repository.ClassRepository;

@Service
public class ClassService {

	@Autowired
	ClassRepository crepo;
	
	//C
	public ClassEntity createClass(ClassEntity class) {
		return crepo.save(class);
	}
	
	//R
	public List<ClassEntity> getAllClass(){
		return crepo.findAll();
	}
	
	//U
	public ClassEntity putClass(int classId, ClassEntity newClass) throws Exception{
		ClassEntity class = new ClassEntity();
		try {
			class = crepo.findById(classId).get();
			class.setSubject(newClass.getSubject());
			class.setYearLevel(newClass.getYearLevel());
			class.setSection(newClass.getSection());
			class.setActive(newClass.isActive());
			return crepo.save(Class);
		}catch(NoSuchElementException e) {
			throw new Exception("Class with ID " +ClassId+ " does not exist.");
		}
	}
	
	//D
	public String deleteClass(int ClassId) {
		String msg;
		if(crepo.findById(ClassId) != null) {
			crepo.deleteById(ClassId);
			msg = "Class with ID " +ClassId+ "is deleted!";
		}else {
			msg = "Class with ID " +ClassId+ "does not exist!";
		}
		return msg;
	}
}