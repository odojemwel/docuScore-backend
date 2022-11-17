package com.docuscore.docs.Entity;

import javax.persistence.Column;
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
	@Column(name="enroll_id")
	private int enrollId;

	
	public EnrollEntity() {}
	public EnrollEntity(int enrollId) {
		super();
		this.enrollId = enrollId;
	}

	
	public int getEnrollId() {
		return enrollId;
	}
	
	
}
