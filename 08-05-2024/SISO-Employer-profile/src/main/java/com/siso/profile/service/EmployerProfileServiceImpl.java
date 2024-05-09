package com.siso.profile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siso.profile.entity.EmployerProfileEntity;
import com.siso.profile.repository.EmployerProfileRepository;

@Service
public class EmployerProfileServiceImpl implements EmployerProfileService{

	
	@Autowired
	EmployerProfileRepository employerProfile;
	
	
	
	@Override
	public EmployerProfileEntity editProfile(EmployerProfileEntity profile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployerProfileEntity getProfile(long profileId) {
		// TODO Auto-generated method stub
		return employerProfile.findById(profileId).orElse(null);
	}
	
	
	

}
