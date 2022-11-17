package com.docuscore.docs.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	@Column(name="stud_school_id")
	private String studSchoolId;
	@Column(name="class_number")
	private int classNumber;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="is_deleted")
	private boolean Isdeleted;
	
	
	public StudentEntity() {}


	public StudentEntity(int studentId, String studSchoolId, int classNumber, String firstName, String lastName,
			boolean isdeleted) {
		super();
		this.studentId = studentId;
		this.studSchoolId = studSchoolId;
		this.classNumber = classNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		Isdeleted = isdeleted;
	}


	public String getStudSchoolId() {
		return studSchoolId;
	}


	public void setStudSchoolId(String studSchoolId) {
		this.studSchoolId = studSchoolId;
	}


	public int getClassNumber() {
		return classNumber;
	}


	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}


	public boolean isIsdeleted() {
		return Isdeleted;
	}


	public void setIsdeleted(boolean isdeleted) {
		Isdeleted = isdeleted;
	}


	public int getStudentId() {
		return studentId;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}

	
	
	
}
