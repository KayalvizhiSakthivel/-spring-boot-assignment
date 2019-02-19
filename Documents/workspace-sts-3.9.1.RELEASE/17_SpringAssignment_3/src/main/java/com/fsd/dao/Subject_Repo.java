package com.fsd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsd.model.Subject;

@Repository
public interface Subject_Repo extends CrudRepository<Subject, Long> {

	List<Subject> findAllBySubjectId(long subjectId);

	@Query(value = "select subjectId,subtitle,durationInHours from subject_data where durationInHours=?1", nativeQuery = true)
	public Subject findSubjectByDur(int durationInHours);

}