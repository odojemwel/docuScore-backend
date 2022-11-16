package com.docuscore.docs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_enroll")
public class EnrollEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int enroll_id;

	
	public EnrollEntity() {}
	public EnrollEntity(int enroll_id) {
		super();
		this.enroll_id = enroll_id;
	}

	
	public int getEnroll_id() {
		return enroll_id;
	}
	
	
}
