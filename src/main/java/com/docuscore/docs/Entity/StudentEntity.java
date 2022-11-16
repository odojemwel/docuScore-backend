package com.docuscore.docs.Entity;

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
	private String student_id;
	private String stud_school_id;
	private int class_number;
	private String first_name;
	private String last_name;
	private boolean is_deleted;
	
	
	public StudentEntity() {}
	public StudentEntity(String student_id, String stud_school_id, int class_number, String first_name,
			String last_name, boolean is_deleted) {
		super();
		this.student_id = student_id;
		this.stud_school_id = stud_school_id;
		this.class_number = class_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.is_deleted = is_deleted;
	}


	public int getClass_number() {
		return class_number;
	}

	public void setClass_number(int class_number) {
		this.class_number = class_number;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getStudent_id() {
		return student_id;
	}

	public String getStud_school_id() {
		return stud_school_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}
	
	
	
	
}
