package com.docuscore.docs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_teacher")
public class TeacherEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teacher_id;
	private String employee_id;
	private String first_name;
	private String last_name;
	private String date_employed;
	private String password;
	private boolean is_active;
	
	
	public TeacherEntity() {}
	public TeacherEntity(int teacher_id, String employee_id, String first_name, String last_name, String date_employed,
			String password, boolean is_active) {
		super();
		this.teacher_id = teacher_id;
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_employed = date_employed;
		this.password = password;
		this.is_active = is_active;
	}

	
	public int getTeacher_id() {
		return teacher_id;
	}

	public String getDate_employed() {
		return date_employed;
	}
	
	public void setDate_employed(String date_employed) {
		this.date_employed = date_employed;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isIs_active() {
		return is_active;
	}
	
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	public String getEmployee_id() {
		return employee_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	
	
}
