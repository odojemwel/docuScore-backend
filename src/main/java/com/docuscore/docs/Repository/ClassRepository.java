package com.docuscore.docs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docuscore.docs.Entity.TeacherEntity;

@Repository
public interface ClassRepository extends JpaRepository<TeacherEntity, Integer>{

}