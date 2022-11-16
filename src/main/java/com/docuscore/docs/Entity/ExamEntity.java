package com.docuscore.docs.Entity;

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
	private int exam_id;
	private int exam_no;
	private String exam_title;
	private int total_items;
	private boolean is_deleted;
	
	
	public ExamEntity() {}
	public ExamEntity(int exam_id, int exam_no, String exam_title, int total_items, boolean is_deleted) {
		super();
		this.exam_id = exam_id;
		this.exam_no = exam_no;
		this.exam_title = exam_title;
		this.total_items = total_items;
		this.is_deleted = is_deleted;
	}


	public int getExam_no() {
		return exam_no;
	}

	public void setExam_no(int exam_no) {
		this.exam_no = exam_no;
	}

	public String getExam_title() {
		return exam_title;
	}

	public void setExam_title(String exam_title) {
		this.exam_title = exam_title;
	}

	public int getTotal_items() {
		return total_items;
	}

	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public int getExam_id() {
		return exam_id;
	}
	
	
	
}
