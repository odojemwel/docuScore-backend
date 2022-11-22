package com.docuscore.docs.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_enroll")
public class EnrollEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enroll_id")
	private int enrollId;

	@ManyToOne
	@JoinColumn(name="student_id",
			referencedColumnName="student_id",
			nullable=false
			)
	private StudentEntity student;
	
	@ManyToOne
	@JoinColumn(name="class_id",
			referencedColumnName="class_id",
			nullable=false
			)
	private ClassEntity class_enrolled;
	
		
	public EnrollEntity() {
		super();
	}
	public EnrollEntity(int enrollId, StudentEntity student, ClassEntity class_enrolled) {
		super();
		this.enrollId = enrollId;
		this.student = student;
		this.class_enrolled = class_enrolled;
	}


	public int getEnrollId() {
		return enrollId;
	}
	public StudentEntity getStudent() {
		return student;
	}
	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	public ClassEntity getClass_enrolled() {
		return class_enrolled;
	}
	public void setClass_enrolled(ClassEntity class_enrolled) {
		this.class_enrolled = class_enrolled;
	}
	
	
}
