package com.docuscore.docs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docuscore.docs.Entity.ExamEntity;
import com.docuscore.docs.Repository.ExamRepository;

@Service
public class ExamService {

	@Autowired
	ExamRepository erepo;
	
	//C
	public ExamEntity createExam(ExamEntity exam) {
		return erepo.save(exam);
	}
	
	//R
	public List<ExamEntity> getAllExam(){
		return erepo.findAll();
	}
	
	//U
	public ExamEntity putExam(int examId, ExamEntity newexam) throws Exception{
		ExamEntity exam = new ExamEntity();
		try {
			exam = erepo.findById(examId).get();
			exam.setExamNo(exam.getExamNo());
			exam.setExamTitle(exam.getExamTitle());
			exam.setTotalItems(exam.getTotalItems());
			exam.setDeleted(exam.isDeleted());
			return erepo.save(exam);
		}catch(NoSuchElementException e) {
			throw new Exception("exam with ID " +examId+ " does not exist.");
		}
	}
	
	//D
	public String deleteExam(int examId) {
		String msg;
		if(erepo.findById(examId) != null) {
			erepo.deleteById(examId);
			msg = "exam with ID " +examId+ "is deleted!";
		}else {
			msg = "exam with ID " +examId+ "does not exist!";
		}
		return msg;
	}
}
