package com.docuscore.docs.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_teacher")
public class TeacherEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private int teacherId;
	
	@Column(name="employee_id")
	private String employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="date_employed") //'YYYY-MM-DD'
	@Temporal(TemporalType.DATE)
	private Date dateEmployed;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_deleted", columnDefinition = "BOOLEAN")
	private boolean isDeleted;
	
	@OneToMany(mappedBy="teacher")
	private Set<ClassEntity> classes;
	
	public TeacherEntity() {}

	public TeacherEntity(int teacherId, String employeeId, String firstName, String lastName, Date dateEmployed,
			String password, boolean isDeleted) {
		super();
		this.teacherId = teacherId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateEmployed = dateEmployed;
		this.password = password;
		this.isDeleted = isDeleted;
	}


	public Date getDateEmployed() {
		return dateEmployed;
	}


	public void setDateEmployed(Date dateEmployed) {
		this.dateEmployed = dateEmployed;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getTeacherId() {
		return teacherId;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}
	
	
}
