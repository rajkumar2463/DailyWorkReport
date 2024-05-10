package com.siso.profile.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siso.profile.entity.Contract2HireEntity;
import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.EmployerEntity;
import com.siso.profile.entity.JobPostEntity;
import com.siso.profile.entity.ProjectPost;
import com.siso.profile.repository.Contract2HireRepository;
import com.siso.profile.repository.EmployeeEntityRepo;
import com.siso.profile.repository.EmployerRepository;
import com.siso.profile.repository.JobPostRepository;
import com.siso.profile.repository.ProjectPostRepository;


@Service
public class EmployerServiceImpl implements EmployerService{

	
	@Autowired
	EmployerRepository  employerrepo;
	
	
	@Autowired
	EmployeeEntityRepo employeerepo; 
	
	@Autowired
	ProjectPostRepository projectsrepo;
	
	@Autowired
	Contract2HireRepository c2hrepo;
	
	@Override
	public EmployerEntity registeremployer(EmployerEntity employer) {
		// TODO Auto-generated method stub
		
		 String uniqueId = generatedUniqueId(employer.getNameOftheCompany(),employer.getDesignation());

	        // Set the generated ID to the user
	        employer.setEmployerId(uniqueId);
	        //patient.setPatientId(generateUniqueID(patient.getPatientName(),patient.getCity(), patient.getState()));
	        return employerrepo.save(employer);
			
	}

	

	
	 private String generatedUniqueId( String nameOftheCompany, String designation) {
	        // Get the first letter of each field
	        char firstLetterOfCity = nameOftheCompany.charAt(0);
	        char firstLetterOfState = designation.charAt(0);

	        // Generate random numbers (you can customize this logic)
	        String randomNumbers = String.valueOf(new Random().nextInt(9000) + 1000);

	        // Combine the letters and random numbers to create the unique ID
	        return String.format("%c%c%s",  firstLetterOfCity, firstLetterOfState, randomNumbers);
	    }
	@Override
	public EmployerEntity getemployer(String employerId) {
		// TODO Auto-generated method stub
		Optional<EmployerEntity>employ=employerrepo.findByEmployerId(employerId);
		if(employ.isPresent())
		{
			EmployerEntity emp=employ.get();
			return emp;
		}
		else
			
		throw new RuntimeException("Employer Data Not Found");
	}

	

	@Override
	public List<EmployerEntity> getallemployers() {
		// TODO Auto-generated method stub
		return employerrepo.findAll();
	}
	
	@Override
	public String loginEmployer(String companyEmail, String password) {
		EmployerEntity employerEntity = employerrepo.findByCompanyEmailAndPassword(companyEmail, password);
		if (employerEntity != null) {
			return "login succesfull";
		}
		return "login failed";
	}


	@Override
	public String deleteEmployerId(String employerId) {
		// TODO Auto-generated method stub
		Optional<EmployerEntity>exists=employerrepo.findByEmployerId(employerId);
		if(exists.isPresent())
		{
			employerrepo.deleteById(employerId);
		return "Successfully deleted employer Data";
		}
		return "Failed to delete employer data";
	}
		
	
	
	@Autowired
	JobPostRepository jobpostrepo; 

	
	@Override
	public EmployerEntity addJobpost(String employerId, JobPostEntity jobpost) {
		// TODO Auto-generated method stub
		
		
		 Optional<EmployerEntity> empExist = employerrepo.findByEmployerId(employerId);
			
			if(empExist.isPresent()) {	
				
				EmployerEntity emp = empExist.get();
				jobpost.setEmployer(emp);				
				jobpostrepo.save(jobpost);
		        return emp;	
					}
			throw new RuntimeException("Employer Id Not Found: "+employerId);
	}




	@Override
	public List<JobPostEntity> getAllJobposts() {
		// TODO Auto-generated method stub
		return jobpostrepo.findAll();
	}


	@Override
	public String deleteJobpostById(Long jobPostId) {
		Optional<JobPostEntity> existorNot = jobpostrepo.findByJobPostId(jobPostId);
		if(existorNot.isPresent()) {
			JobPostEntity job = existorNot.get();
			job.setEmployer(null);
			jobpostrepo.deleteById(jobPostId);
			return "Successfully Deleted Data with " +job.getCompany();
		}
		return jobPostId+" is Not-Matched With Database";
	}



	@Override
	public JobPostEntity findByJobPostId(Long jobPostId) {
		// TODO Auto-generated method stub
		
		Optional<JobPostEntity> getjobpost = jobpostrepo.findByJobPostId(jobPostId);
		if(getjobpost.isPresent()) {
			JobPostEntity job = getjobpost.get();
		     return job;
		     }
	     	throw new RuntimeException("Job Post Data is Not Found / Unable to Process at this Movement");
	  }




	@Override
	public EmployerEntity addProject(String employerId, ProjectPost projects) {
		// TODO Auto-generated method stub

		 Optional<EmployerEntity> empExist = employerrepo.findByEmployerId(employerId);
			
			if(empExist.isPresent()) {	
				
				EmployerEntity emp = empExist.get();
				projects.setEmployer(emp);				
				projectsrepo.save(projects);
		        return emp;	
					}
			throw new RuntimeException("Employer Id Not Found: "+employerId);
	}




	@Override
	public List<ProjectPost> getallProjects() {
		// TODO Auto-generated method stub
		return projectsrepo.findAll();
	}




	@Override
	public ProjectPost findByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		
		Optional<ProjectPost> getproject = projectsrepo.findByProjectId(projectId);
		if(getproject.isPresent()) {
			ProjectPost project = getproject.get();
		     return project;
		     }
	     	throw new RuntimeException("Project Data is Not Found");
	}




	@Override
	public EmployerEntity addc2h(String employerId, Contract2HireEntity c2h) {


		 Optional<EmployerEntity> empExist = employerrepo.findByEmployerId(employerId);
			
			if(empExist.isPresent()) {	
				
				EmployerEntity emp = empExist.get();
			
				c2h.setEmployer(emp);				
				c2hrepo.save(c2h);
		        return emp;	
					}
			throw new RuntimeException("Employer Id Not Found: "+employerId);
	}




	@Override
	public List<Contract2HireEntity> getallc2h() {
		// TODO Auto-generated method stub
		return c2hrepo.findAll();
	}




	@Override
	public Contract2HireEntity findHiring(Long c2hId) {
		Optional<Contract2HireEntity> gethire = c2hrepo.findByC2HId(c2hId);
		if(gethire.isPresent()) {
			Contract2HireEntity hiring = gethire.get();
		     return hiring;
		     }
	     	throw new RuntimeException("Hiring Data is Not Found");
	}




//	@Override
//	public Boolean saveApply(JobPostEntity apply, String employeeId, String employerId) {
//		
//		Optional<EmployeeEntity> optinalEmployee = employeerepo.findById(employeeId);
//		Optional<EmployerEntity> optinalEmployer = employerrepo.findById(employerId);
//		/*
//		 * Optional<EmployeeEntity> optinalEmpId = employeerepo.findById(employeeId);
//		 * 
//		 * Optional<EmployerEntity> optinalEmployeerId =
//		 * employerrepo.findByEmployerId(employerId);
//		 */
//		if (optinalEmployee.isPresent() && optinalEmployer.isPresent()) {
//			EmployeeEntity employee = optinalEmployee.get();
//			EmployerEntity employer = optinalEmployer.get();
//
//			apply.setEmployee(employee);
//			apply.setEmployer(employer);
//
//			jobpostrepo.save(apply);
//			return true;
//
//		}
//
//		return false;
//	}
//

	

	


	
}
