package com.docuscore.docs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docuscore.docs.Entity.EnrollEntity;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, Integer>{

	//void save();
}
