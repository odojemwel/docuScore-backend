package com.docuscore.docs.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_class")
public class ClassEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="class_id")
	private int classId;
	@Column(name="subject")
	private String subject;
	@Column(name="year_level")
	private int yearLevel;
	@Column(name="section")
	private String section;
	@Column(name="is_deleted", columnDefinition = "BOOLEAN")
	private boolean isDeleted;
	
	@ManyToOne
	@JoinColumn(name="teacher_id",
			referencedColumnName="teacher_id",
			nullable=false)
	private TeacherEntity teacher;
	
	@OneToMany(mappedBy="class_enrolled", cascade=CascadeType.ALL)
	private Set<EnrollEntity> enrolled_students;
	
	@OneToMany(mappedBy="classId", cascade=CascadeType.ALL)
	private Set<ExamEntity> exams;
	
	
	public ClassEntity() {}
	public ClassEntity(int classId, String subject, int yearLevel, String section, boolean isDeleted) {
		super();
		this.classId = classId;
		this.subject = subject;
		this.yearLevel = yearLevel;
		this.section = section;
		this.isDeleted = isDeleted;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public TeacherEntity getTeacher() {
		return teacher;
	}
	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}
	public int getClassId() {
		return classId;
	}


		
}
