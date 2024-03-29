package com.docuscore.docs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docuscore.docs.Entity.ClassEntity;
import com.docuscore.docs.Entity.EnrollEntity;
import com.docuscore.docs.Entity.StudentEntity;
import com.docuscore.docs.Repository.ClassRepository;
import com.docuscore.docs.Repository.EnrollRepository;
import com.docuscore.docs.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository srepo;
	
	@Autowired
	EnrollRepository enrepo;
	
	@Autowired
	ClassRepository clrepo;
	
	//Create
		public StudentEntity insertStudent(StudentEntity student, int class_id) {
			EnrollEntity enroll = new EnrollEntity();
			ClassEntity classe = clrepo.findByClassId(class_id);
			enroll.setStudent(student);
			enroll.setClass_enrolled(classe);
			student = srepo.save(student);
			enrepo.save(enroll);
			return student;
		}
		
	//Read all
		public List<StudentEntity> getAllStudents(){
			return srepo.findAll();
		}
		
	//findStudentById
		public StudentEntity getStudentById(int id) {
			if (srepo.findByStudentId(id) != null)
				return srepo.findByStudentId(id);
			else
				return null;
		}

	public StudentEntity findByClassNumber(int sNumber){
		if (srepo.findByClassNumber(sNumber) != null) {
			return srepo.findByClassNumber(sNumber);
		}
		return null;
	}

	//get Student by ClassId
		public List<StudentEntity> getStudentByClassId(int classId){
			return srepo.findByClassId(classId);
		}

	//Update
		public StudentEntity putStudent(int studentId, StudentEntity newStudentDetails) throws Exception {
			
			StudentEntity student = new StudentEntity();
			
			try {
				//steps in updating
				
				//Step 1 - search the id number of the student
				student = srepo.findById(studentId).get();

				//Step 2 - update the record
				student.setStudSchoolId(newStudentDetails.getStudSchoolId());
				student.setClassNumber(newStudentDetails.getClassNumber());
				student.setDeleted(newStudentDetails.isDeleted());
				student.setFirstName(newStudentDetails.getFirstName());
				student.setLastName(newStudentDetails.getLastName());
				
				//Step 3 - save the information and return the value
				return srepo.save(student);
			
			} catch(NoSuchElementException nex) {
				throw new Exception("ID Number " + studentId + " does not exist!");
			}
		}		
		
	//Delete student record
		public String deleteStudent(int studentId) {
			String msg;
			
			if ( srepo.findById(studentId) != null ) {		//Step 1 - find the record
				srepo.deleteById(studentId); 				//Step 2 - delete the record
				
				msg = "Student ID Number " + studentId + " is successfully deleted!";
			}
			else
				msg = "Student ID Number " + studentId + " is NOT found!";
		
			return msg;
		}
		

} 
