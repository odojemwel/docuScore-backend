package com.docuscore.docs.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tbl_score",
		uniqueConstraints={@UniqueConstraint(name = "UniqueExamStudent",
				columnNames = {"exam_id", "student_id"})})
public class ScoreEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="score_id")
	private int scoreId;
	@Column(name="value")
	private float value;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="exam_id", 
			referencedColumnName="exam_id",
			nullable = false
			)
	private ExamEntity exam;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="student_id",
			referencedColumnName="student_id",
			nullable = false
			)
	private StudentEntity student;

	public ScoreEntity() {
		super();
	}

	public ScoreEntity(int scoreId, float value, ExamEntity exam, StudentEntity student) {
		super();
		this.scoreId = scoreId;
		this.value = value;
		this.exam = exam;
		this.student = student;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public ExamEntity getExam() {
		return exam;
	}

	public void setExam(ExamEntity exam) {
		this.exam = exam;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public int getScoreId() {
		return scoreId;
	}
	
	
}
