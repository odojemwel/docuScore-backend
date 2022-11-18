package com.docuscore.docs.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name="is_active", columnDefinition = "BOOLEAN")
	private boolean isActive;
	
	
	public ClassEntity() {}
	public ClassEntity(int classId, String subject, int yearLevel, String section, boolean isActive) {
		super();
		this.classId = classId;
		this.subject = subject;
		this.yearLevel = yearLevel;
		this.section = section;
		this.isActive = isActive;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getClassId() {
		return classId;
	}

	
		
}
