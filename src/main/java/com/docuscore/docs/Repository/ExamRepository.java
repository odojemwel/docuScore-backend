package com.docuscore.docs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docuscore.docs.Entity.ExamEntity;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Integer>{

}
