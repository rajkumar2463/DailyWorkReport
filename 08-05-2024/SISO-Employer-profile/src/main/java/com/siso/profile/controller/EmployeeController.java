package com.siso.profile.controller;



import java.io.IOException;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.siso.profile.entity.EmployeeEntity;
import com.siso.profile.entity.JobPostEntity;
import com.siso.profile.repository.EmployeeEntityRepo;
import com.siso.profile.service.EmployeeService;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/svc/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@Autowired
	private EmployeeEntityRepo employeerepo;


//	@Autowired
//	private AddressRepo addressRepo;

	@Autowired
	private JavaMailSender javaMailSender1;

//	public EmployeeController(EmployeeServiceImpl employeeServiceImpl, EmployeeRepo employeerepo,
//			AddressRepo addressRepo, JavaMailSender javaMailSender1) {
//		super();
//		this.employeeServiceImpl = employeeServiceImpl;
//		this.employeerepo = employeerepo;
//		this.addressRepo = addressRepo;
//		this.javaMailSender1 = javaMailSender1;
//	}

//		
	// Method to generate unique ID based on email and role
	// private String generateUniqueId(String userName, String email) {
	// Concatenate email and role and hash the result
	// String uniqueString = userName + email;
	// You can use any hashing algorithm here
	// For example, MD5 or SHA-256
	// Here, I'm using a simple hashcode() method for demonstration
	// return String.valueOf(uniqueString.hashCode());
	// }

	
	
	 @PostMapping("/saveemployee")
	    public ResponseEntity<String> handlePostRequest(@RequestBody EmployeeEntity employee) {
	      
	        
	        EmployeeEntity savedEmployee = employeerepo.save(employee);

	        String responseBody = "Employee saved successfully with ID: " + savedEmployee.getEmployeeId();

	        // Return ResponseEntity with custom response body and HTTP status
	        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
	    }
	 
	 
	 
	 
	private static String generateUniqueId(String userName, String email) {
		// Extracting first 3 letters from username and email
		String userNamePrefix = userName.substring(0, Math.min(userName.length(), 3));
		String emailPrefix = email.substring(0, Math.min(email.length(), 3));

		// Concatenating the prefixes
		String uniqueId = userNamePrefix + emailPrefix;

		// If the resulting string is less than 9 characters, pad with zeros
		if (uniqueId.length() < 9) {
			uniqueId = String.format("%-9s", uniqueId).replace(' ', '0');
		}

		// If the resulting string is longer than 9 characters, truncate to 9 characters
		else if (uniqueId.length() > 9) {
			uniqueId = uniqueId.substring(0, 9);
		}

		return uniqueId;
	}

	@PostMapping("/getotp/{email}/{userName}")
	public String saveOTP(@PathVariable String email, @PathVariable String userName) {
		EmployeeEntity empEnt = employeerepo.findByEmail(email);
		if (empEnt != null) {
			return "User Already Exists";
		}
		if (empEnt == null) {
			EmployeeEntity e = new EmployeeEntity();
			String uniqueId = generateUniqueId(userName, email);
			e.setEmployeeId(uniqueId);
			e.setUserName(userName);
			e.setEmail(email);
			String OTP = generateRandomOTP();
			e.setEmailOtp(OTP);

			sendEmail(email, OTP);

			employeerepo.save(e);

		}
		return "email ok";
	}

	private String generateRandomOTP() {
		Random random = new Random();
		return String.format("%04d", random.nextInt(10000));
	}

	private void sendEmail(String email, String emailOtp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP Verification");
		message.setText("Your OTP for verification is: " + emailOtp);
		javaMailSender1.send(message);
	}

	@GetMapping("/getallemployees")
	public List<EmployeeEntity> findAllEmployees() {
		
		return employeeservice.findAllEmployees();
	}

	@PostMapping("/createuser")
	public ResponseEntity<String>  createEmployee(

			@RequestParam("resume") MultipartFile resume, @RequestParam("phone") String phone,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("jobRole") String jobRole, @RequestParam("workstatus") String workStatus,
			@RequestParam("registerAs") String registerAs, @RequestParam("years") Integer years,
			@RequestParam("months") Integer months) throws IOException {

		EmployeeEntity e = employeerepo.findByEmail(email);

		if (e != null) {
			// String uniqueId = generateUniqueId(userName, email); // Generating unique ID

			// e.setEmployeeId(uniqueId);

			if ("fresher".equalsIgnoreCase(workStatus)) {
	            // If the employee is a fresher, set years, months, and jobRole to null
	            years = null;
	            months = null;
	            jobRole = null;
	        }
			e.setWorkStatus(workStatus);
			e.setPhone(phone);
			e.setPassword(password);
			e.setJobRole(jobRole);
			e.setRegisterAs(registerAs);
			e.setYears(years);
			e.setMonths(months);
			e.setResume(resume.getBytes());

			employeerepo.save(e);

			return ResponseEntity.ok(" user Registered");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("check your credentials");

		

	}

	@GetMapping("/get/{employeeId}")
	public EmployeeEntity getemployee(@PathVariable String employeeId)
	{
		return employeeservice.getemployee(employeeId);
	}


	@DeleteMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable String employeeId)
	{
		
		return employeeservice.deleteEmployee(employeeId);
	}
	

//	
//	  @PostMapping("/{employeeId}/{jobPostId}")
//	    public String applyForJob(@PathVariable String employeeId, @PathVariable Long jobPostId) {
//	        if (employeeservice.saveApply(employeeId, jobPostId)) {
//	            return "Application submitted successfully";
//	        } else {
//	            return "Failed to submit application. Employee or job post not found.";
//	        }
//	    }
//	  
	
	
	
	
	
	
	  
//	@PostMapping("/login")
//	public String loginUser(@RequestBody EmailLogin request ) {
//				EmployeeEntity e=employeerepo.findByEmail(request.getEmail());
//				if (e!=null && e.getPassword().equals(request.getPassword())) {
//					return "login successfull";
//				}
//				
//				return "check your credentials";
//	        
//
//		
//	}

//	@PutMapping("/personalinfo/{employeeId}")
//	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable String employeeId,
//			@RequestBody EmployeeEntity employeeEntity) {
//		EmployeeEntity empent = employeerepo.updateEmployee(employeeId, employeeEntity);
//
//		return ResponseEntity.ok(empent);
//
//	}

	@PostMapping("/verify/{email}/{enteredOTP}")
	public boolean verifyOTP(@PathVariable String email, @PathVariable String enteredOTP) {
		EmployeeEntity empEnt = employeerepo.findByEmail(email);
		if (empEnt != null && empEnt.getEmailOtp() != null && empEnt.getEmailOtp().equals(enteredOTP)) {
			empEnt.setEmailOtp(null);
			employeerepo.save(empEnt);
			return true;
		} else {
			return false;
		}

	}

	@PostMapping("/passwordreset/{email}")
	public ResponseEntity<String> otpForPasswordReset(@PathVariable String email) {
		
		try {
			EmployeeEntity empEnt = employeerepo.findByEmail(email);
			if (empEnt != null) {

				//empEnt.setPassword(newPassword);

				//empEnt.setNewPassword(null);

				String OTP = randomOTPForPassword();
				empEnt.setEmailOtp(OTP);

				sendEmail(email, OTP);

				employeerepo.save(empEnt);

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

	private void sendEmailForPasswordReset(String email, String emailOtp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP Verification");
		message.setText("Your OTP for passwordReset is: " + emailOtp);
		javaMailSender1.send(message);
	}

	@PostMapping("/verifyotpfornewpassword/{email}/{enteredOTP}/{newPassword}/{confirmNewPassword}")
	public ResponseEntity<String> verifyOTPForNewPassword(@PathVariable String email, @PathVariable String enteredOTP, @PathVariable String newPassword) {
		
try {
	EmployeeEntity empEnt = employeerepo.findByEmail(email);
	if (empEnt != null && empEnt.getEmailOtp() != null
			&& empEnt.getEmailOtp().equals(enteredOTP) ) {
		
		empEnt.setPassword(newPassword);
		empEnt.setNewPassword(null);
		empEnt.setEmailOtp(null);
		employeerepo.save(empEnt);
		return ResponseEntity.ok("password Reset succesfully");
	} 

	
} catch (Exception e) {
	e.printStackTrace();
}
 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("check your credentials");		
		
	}
	
	@PostMapping("/applyjob/{employeeId}")
	public EmployeeEntity save(@PathVariable String employeeId, @RequestBody List<JobPostEntity> apply) {
		
		
		return employeeservice.save(employeeId, apply);

		
	}
	

//	@PostMapping("/addemployement/{employeeId}")
//	public AddEmployementEntity createEmployement(@PathVariable String EmployeeId,@RequestBody AddEmployementEntity aee) {
//		return	employeeServiceImpl.createEmployement(EmployeeId, aee);
//	}
}