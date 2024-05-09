package com.siso.profile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siso.profile.entity.EmployerEntity;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerEntity, String>{

	EmployerEntity findByCompanyEmail(String companyEmail);

	

	Optional<EmployerEntity> findByEmployerId(String employerId);




	EmployerEntity findByCompanyEmailAndPassword(String companyEmail, String password);

}
