package com.docuscore.docs.Entity;

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
	private int class_id;
	private String subject;
	private int year_level;
	private String section;
	private boolean is_active;
	
	
	public ClassEntity() {}
	public ClassEntity(int class_id, String subject, int year_level, String section, boolean is_active) {
		super();
		this.class_id = class_id;
		this.subject = subject;
		this.year_level = year_level;
		this.section = section;
		this.is_active = is_active;
	}


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getYear_level() {
		return year_level;
	}

	public void setYear_level(int year_level) {
		this.year_level = year_level;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public int getClass_id() {
		return class_id;
	}
		
}
