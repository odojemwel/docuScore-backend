package com.docuscore.docs.Entity;

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
	private int score_id;
	private float value;
	
	
	public ScoreEntity() {}
	public ScoreEntity(int score_id, float value) {
		super();
		this.score_id = score_id;
		this.value = value;
	}


	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getScore_id() {
		return score_id;
	}
	
}
