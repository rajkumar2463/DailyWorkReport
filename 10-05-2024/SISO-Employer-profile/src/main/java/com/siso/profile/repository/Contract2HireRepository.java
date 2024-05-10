package com.siso.profile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siso.profile.entity.Contract2HireEntity;

@Repository
public interface Contract2HireRepository extends JpaRepository<Contract2HireEntity, Long> {

	Optional<Contract2HireEntity> findByC2HId(Long c2hId);

}
