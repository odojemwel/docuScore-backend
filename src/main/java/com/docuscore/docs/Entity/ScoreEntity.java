package com.docuscore.docs.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_score")
public class ScoreEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="score_id")
	private int scoreId;
	@Column(name="value")
	private float value;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="exam_id", 
			referencedColumnName="exam_id", 
			nullable=false
			)
	private ExamEntity exam;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id",
			referencedColumnName="student_id",
			nullable=false
			)
	private StudentEntity student;
	
	public ScoreEntity() {}
	

	public ScoreEntity(int scoreId, float value) {
		super();
		this.scoreId = scoreId;
		this.value = value;
	}

}
