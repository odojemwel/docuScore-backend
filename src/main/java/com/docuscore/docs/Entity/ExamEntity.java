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
@Table(name="tbl_exam")
public class ExamEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exam_id")
	private int examId;
	@Column(name="exam_no")
	private int examNo;
	@Column(name="exam_title")
	private String examTitle;
	@Column(name="total_items")
	private int totalItems;
	@Column(name="is_deleted", columnDefinition = "BOOLEAN")
	private boolean isDeleted;
	
//	@OneToOne(mappedBy="exam", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private ScoreEntity score;
	@OneToMany(mappedBy="exam", cascade=CascadeType.ALL)
	private Set<ScoreEntity> score;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="class_id",
			referencedColumnName="class_id",
			nullable=false
			)
	private ClassEntity classId;

	
	public ExamEntity() {
		super();
	}

	public ExamEntity(int examId, int examNo, String examTitle, int totalItems, boolean isDeleted, ClassEntity classId) {
		super();
		this.examId = examId;
		this.examNo = examNo;
		this.examTitle = examTitle;
		this.totalItems = totalItems;
		this.isDeleted = isDeleted;
		this.classId = classId;
	}

	public int getExamNo() {
		return examNo;
	}

	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}

	public String getExamTitle() {
		return examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public ClassEntity getClassId() {
		return classId;
	}

	public void setClassId(ClassEntity classId) {
		this.classId = classId;
	}

	public int getExamId() {
		return examId;
	}
		
	
	
}
