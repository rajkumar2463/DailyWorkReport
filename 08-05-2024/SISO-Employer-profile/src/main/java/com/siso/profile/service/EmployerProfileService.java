package com.siso.profile.service;

import com.siso.profile.entity.EmployerProfileEntity;

public interface EmployerProfileService {
	
	public EmployerProfileEntity editProfile(EmployerProfileEntity profile);
	
	public EmployerProfileEntity getProfile(long profileId);
	

}


