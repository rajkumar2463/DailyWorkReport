package com.siso.profile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siso.profile.entity.ProjectPost;

@Repository
public interface ProjectPostRepository extends JpaRepository<ProjectPost, Long>{

	Optional<ProjectPost> findByProjectId(Long projectId);
	
	

}
