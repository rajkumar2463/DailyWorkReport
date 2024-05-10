package com.siso.profile.service;

import java.util.List;

import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.EmployerEntity;
import com.siso.profile.entity.JobPostEntity;

public interface EmployeeService {
	
	
	public List<EmployeeEntity> findAllEmployees();
	
	public String deleteEmployee(String employeeId);
	
	public EmployeeEntity getemployee(String employeeId);

	
	public EmployeeEntity save(String employeeId, List<JobPostEntity> apply) ;


}
