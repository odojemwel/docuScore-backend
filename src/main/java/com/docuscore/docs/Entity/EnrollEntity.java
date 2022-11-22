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
		referencedColumnName="student_id"
		)
	private StudentEntity student;
	
	public EnrollEntity() {}
	public EnrollEntity(int enrollId) {
		super();
		this.enrollId = enrollId;
	}

	
	public int getEnrollId() {
		return enrollId;
	}
	
	
}
