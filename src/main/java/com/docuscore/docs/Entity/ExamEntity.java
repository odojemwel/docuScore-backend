package com.docuscore.docs.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	public ExamEntity() {}


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


	public int getExamId() {
		return examId;
	}

	
	
	
}
