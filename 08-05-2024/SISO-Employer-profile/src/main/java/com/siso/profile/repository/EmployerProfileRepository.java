package com.siso.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siso.profile.entity.EmployerProfileEntity;

@Repository
public interface EmployerProfileRepository extends JpaRepository<EmployerProfileEntity, Long> {

}
