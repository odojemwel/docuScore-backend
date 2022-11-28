package com.docuscore.docs.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docuscore.docs.Entity.ClassEntity;
import com.docuscore.docs.Entity.TeacherEntity;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Integer>{
	
	List<ClassEntity> findByTeacher(TeacherEntity teacher);
	ClassEntity findByClassId(int classId);
}
