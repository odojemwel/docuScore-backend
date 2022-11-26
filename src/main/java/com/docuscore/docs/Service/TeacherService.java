package com.docuscore.docs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docuscore.docs.Entity.TeacherEntity;
import com.docuscore.docs.Repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository trepo;
//	ClassRepository clrepo;
	
	//C
	public TeacherEntity createTeacher(TeacherEntity teacher) {
		return trepo.save(teacher);
	}
	
	//R
	public List<TeacherEntity> getAllTeacher(){
		return trepo.findAll();
	}
	
	//U
	public TeacherEntity putTeacher(int teacherId, TeacherEntity newTeacher) throws Exception{
		TeacherEntity teacher = new TeacherEntity();
		try {
			teacher = trepo.findById(teacherId).get();
			teacher.setDateEmployed(newTeacher.getDateEmployed());
			teacher.setDeleted(newTeacher.isDeleted());
			teacher.setPassword(newTeacher.getPassword());
			return trepo.save(teacher);
		}catch(NoSuchElementException e) {
			throw new Exception("Teacher with ID " +teacherId+ " does not exist.");
		}
	}
	
	//D
	public String deleteTeacher(int teacherId) {
		String msg;
		if(trepo.findById(teacherId).orElse(null) != null) {
			trepo.deleteById(teacherId);
			msg = "Teacher with ID " +teacherId+ " is deleted!";
		}else {
			msg = "Teacher with ID " +teacherId+ " does not exist!";
		}
		return msg;
	}
	
	
	//get Teacher By ID
	public TeacherEntity getTeacherById(int id) {
		return trepo.findByTeacherId(id);
	}
	
	
}
