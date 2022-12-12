package com.docuscore.docs.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docuscore.docs.Entity.ClassEntity;
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
	public ExamEntity putExam(int examId, ExamEntity newExam) throws Exception{
		ExamEntity exam = new ExamEntity();
		try {
			exam = erepo.findById(examId).get();
			
			exam.setExamNo(newExam.getExamNo());
			exam.setExamTitle(newExam.getExamTitle());
			exam.setTotalItems(newExam.getTotalItems());
			
			
			return erepo.save(exam);
			
		}catch(NoSuchElementException a) {
			throw new Exception("exam with ID " +examId+ " does not exist.");
		}
	}
	
	//D
	public String deleteExam(int examId) {
		String msg;
		if(erepo.findById(examId) != null) {
			erepo.deleteById(examId);
			msg = "exam with ID " +examId+ " is deleted!";
		}else {
			msg = "exam with ID " +examId+ " does not exist!";
		}
		return msg;
	}
	
	//findExamById
	public ExamEntity getExamById(int examId) {
		return erepo.findByExamId(examId);
	}

	//findExamByClassID
	public List<ExamEntity> getExamByClass(ClassEntity classId) {
		List<ExamEntity> exam = erepo.findByClassId(classId);
		if(exam != null) {
			return exam;
		}else
		return null;
	}

}
