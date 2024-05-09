package com.siso.profile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siso.profile.entity.JobPostEntity;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostEntity, Long>{

	

	Optional<JobPostEntity> findByJobPostId(Long jobPostId);

	void save(Optional<JobPostEntity> job);

}
