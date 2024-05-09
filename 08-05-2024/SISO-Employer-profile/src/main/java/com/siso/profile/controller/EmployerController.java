package com.siso.profile.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.EmployerEntity;
import com.siso.profile.entity.EmployerProfileEntity;
import com.siso.profile.entity.JobPostEntity;
import com.siso.profile.entity.ProjectPost;
import com.siso.profile.repository.EmployerRepository;
import com.siso.profile.repository.ProjectPostRepository;
import com.siso.profile.service.EmployerService;

@RestController
@CrossOrigin("*")
public class EmployerController {
	
	@Autowired
	EmployerRepository  employerrepo;
	
	@Autowired
	EmployerService employerservice;
	
	@Autowired
	ProjectPostRepository projectrepo; 
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@PostMapping("/register")
	public EmployerEntity registeremployer(@RequestBody EmployerEntity employer) {
		
		return employerservice.registeremployer(employer);
	}

	
	@PostMapping("/companylogin/{companyEmail}/{password}")
	public String loginEmployer( @PathVariable String companyEmail,@PathVariable String password) {
		return employerservice.loginEmployer(companyEmail, password);
		
	}
	 @PutMapping("/updateprofiles/{employerId}")
	    public ResponseEntity<EmployerEntity> handleFileUpload(
	            @PathVariable String employerId,
	            @RequestParam("userName") String userName,
	            @RequestParam("GSTIN") String GSTIN,
	            @RequestParam("alternateMobileNumber") String alternateMobileNumber,
	            @RequestParam("pan") String pan,
	            @RequestParam("profilepic") MultipartFile profilepic
	    ) {
	        try {
	            // Retrieve the existing employer entity from the repository
	            Optional<EmployerEntity> existingEmployer = employerrepo.findByEmployerId(employerId);

	            // Check if employer exists
	            if (existingEmployer.isPresent()) {
	                return ResponseEntity.notFound().build();
	            }

	            // Update the attributes of the existing employer entity
	            else {
	            	EmployerEntity employer=new EmployerEntity();
	            	employer.setUserName(userName);
	            	employer.setGSTIN(GSTIN);
	            	employer.setAlternateMobileNumber(alternateMobileNumber);
	            	employer.setPan(pan);
	            employer.setProfilepic(profilepic.getBytes());
	            
	           

	            // Save the updated employer entity
	         employerrepo.save(employer);
	          
	            
	            
	            
	            // Return the updated employer entity in the response
	            return ResponseEntity.ok(employer);
	        }
	        }catch (IOException e) {
	            // Handle file processing error
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	 }
	 
	 
	 
	 @PostMapping("/passwordreset/{companyEmail}")
		public ResponseEntity<String> otpForPasswordReset(@PathVariable String companyEmail) {
			
			try {
				EmployerEntity empEnt = employerrepo.findByCompanyEmail(companyEmail);
				if (empEnt != null) {

					//empEnt.setPassword(newPassword);

					//empEnt.setNewPassword(null);

					String OTP = randomOTPForPassword();
					empEnt.setEmailOtp(OTP);

					sendEmail(companyEmail, OTP);

					employerrepo.save(empEnt);

					return ResponseEntity.ok("otp sent to the registered email");	

				
			} 
			}catch (Exception e) {
				e.printStackTrace();
				
			
			}
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("no email found");				
			
		
		}

		private String randomOTPForPassword() {
			Random random = new Random();
			return String.format("%06d", random.nextInt(10000));
		}

		private void sendEmail(String companyEmail, String emailOtp) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(companyEmail);
			message.setSubject("OTP Verification");
			message.setText("Your OTP for passwordReset is: " + emailOtp);
			javaMailSender.send(message);
		}

		@PostMapping("/verifyotpfornewpassword/{companyEmail}/{enteredOTP}/{newPassword}/{confirmNewPassword}")
		public ResponseEntity<String> verifyOTPForNewPassword(@PathVariable String companyEmail, @PathVariable String enteredOTP, @PathVariable String newPassword) {
			
	try {
		EmployerEntity empEnt = employerrepo.findByCompanyEmail(companyEmail);
		if (empEnt != null && empEnt.getEmailOtp() != null
				&& empEnt.getEmailOtp().equals(enteredOTP) ) {
			
			empEnt.setPassword(newPassword);
			empEnt.setNewPassword(null);
			empEnt.setEmailOtp(null);
			employerrepo.save(empEnt);
			return ResponseEntity.ok("password Reset succesfully");
		} 

		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("check your credentials");		
			
		}

	


	 
	@PostMapping("/getotp/{companyEmail}")
	public void saveOTP(@PathVariable String companyEmail) {
        EmployerEntity employer = employerrepo.findByCompanyEmail(companyEmail);
        if (employer != null) {
        	String OTP = generateRandomOTP();
            employer.setEmailOtp(OTP);
            employerrepo.save(employer);

            sendEmailCompany(companyEmail, OTP);
            
        	
        
    }
	}

	private String generateRandomOTP() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }
	
	

	@Autowired
    private JavaMailSender javaMailSender1;
	
	private void sendEmailCompany(String companyEmail, String emailOtp ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(companyEmail);
        message.setSubject("OTP Verification");
        message.setText("Your OTP for verification is: " + emailOtp);
        javaMailSender1.send(message);
    }
//	
	@PostMapping("/verify/{companyEmail}/{enteredEmailOtp}")
	 public boolean verifyOTP(@PathVariable String companyEmail,@PathVariable String enteredEmailOtp) {
		EmployerEntity employers = employerrepo.findByCompanyEmail(companyEmail);
	        
	        
	        		if(employers != null && employers.getEmailOtp() != null && employers.getEmailOtp().equals(enteredEmailOtp))
	        		{
	        			employers.setEmailOtp(null);
	        			employerrepo.save(employers);
	        			return true;
	        		}
	        		else
	        		{
	        			return false;
	        		}

	    }

	
	@GetMapping("/getemployer/{employerId}")
	public EmployerEntity getemployer(@PathVariable String employerId) {
		// TODO Auto-generated method stub
		return employerservice.getemployer(employerId);
		
	}

	@GetMapping("/getallemployers")
	public List<EmployerEntity> getallemployers() {
		
		return  employerservice.getallemployers();
	}

	@DeleteMapping("/deleteId/{employerId}")
	public String deleteEmployerId(@PathVariable String employerId) {
		
		
		return employerservice.deleteEmployerId(employerId);

	}
	
//	@PostMapping("/save/{employeeId}/{employeerId}")
//	public ResponseEntity<String> saveApply(@RequestBody JobPostEntity apply, @PathVariable String employeeId,
//			@PathVariable String employeerId) {
//		
//		Boolean status = employerservice.saveApply(apply, employeerId, employeeId);
//		if (status) {
//			return new ResponseEntity<String>("apply successfully", HttpStatus.CREATED);
//		}
//		return new ResponseEntity<String>("apply not successfully", HttpStatus.OK);
//	}
	
	
	@PostMapping("/postthejob/{employerId}")
     public EmployerEntity addJobpost(@PathVariable String employerId, @RequestBody JobPostEntity jobpost)
     {
		return employerservice.addJobpost(employerId, jobpost);
		
     }
	   	
	 
     @GetMapping("/getalljobposts")
   	 public List<JobPostEntity> getAllJobposts()
   	 {
   		 
    	 return employerservice.getAllJobposts();
   	 }

     @DeleteMapping("/deletePost/{jobPostId}")
 	 public String deleteJobpostById(@PathVariable Long jobPostId)
 	 {
    	 
    	 return employerservice.deleteJobpostById(jobPostId);
 	 }
 	
     
     @GetMapping("/getjobpost/{jobPostId}")
 	 public JobPostEntity findByJobPostId(@PathVariable Long jobPostId)
 	 {
    	 return employerservice.findByJobPostId(jobPostId);
 	 }
	

     
     @PostMapping("/addprojects/{employerId}")
   	    public ResponseEntity<ProjectPost> handleProjects(
	            @PathVariable String employerId,
	            @RequestParam("projectName")String projectName,
	            @RequestParam("budgetType") String budgetType,
	            @RequestParam("budgetAmount") Long budgetAmount,
	            @RequestParam("industry") String industry,
	            @RequestParam("technologies") String technologies,
	            @RequestParam("projectDetails") String projectDetails,
	            @RequestParam("duration") String duration,
	            @RequestParam("file") MultipartFile file,
	            @RequestParam("teamSize") Long teamSize
	    ) {
	        try {
	            // Retrieve the existing employer entity from the repository
	            Optional<EmployerEntity> existingEmployer = employerrepo.findByEmployerId(employerId);

	            // Check if employer exists
	            if (existingEmployer.isPresent()) {
	             

	           
	            	ProjectPost project=new ProjectPost();
	            	project.setProjectName(projectName);
	            	project.setBudgetType(budgetType);
	            	project.setBudgetAmount(budgetAmount);
	            	project.setIndustry(industry);
	            	project.setTechnologies(technologies);
	            	project.setProjectDetails(projectDetails);
	            	project.setDuration(duration);
	            	project.setFile(file.getBytes());
	                project.setTeamSize(teamSize);
	            
	                project.setEmployer(existingEmployer.get());


	            // Save the updated employer entity
	                
	                projectrepo.save(project);
	          
	            
	            
	            
	            // Return the updated employer entity in the response
	            return ResponseEntity.ok(project);
	        }
	            else {
	            	   return ResponseEntity.notFound().build();
            }
	        }catch (IOException e) {
	            // Handle file processing error
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	 }
 	 
     @GetMapping("/getallprojects")
 	 public List<ProjectPost>getallProjects()
 	 {
 		 return employerservice.getallProjects();
 	 }
 	 
     @GetMapping("/getproject/{employerId}")
 	 public ProjectPost findByProjectId(@PathVariable Long projectId)
 	 {
 		 return employerservice.findByProjectId(projectId);
 	 }
	
}
