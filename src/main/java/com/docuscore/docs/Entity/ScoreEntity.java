package com.docuscore.docs.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	public ScoreEntity() {}
	

	public ScoreEntity(int scoreId, float value) {
		super();
		this.scoreId = scoreId;
		this.value = value;
	}

}
