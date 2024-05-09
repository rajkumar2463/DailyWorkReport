package com.siso.profile.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.siso.profile.entity.EmployerProfileEntity;
import com.siso.profile.repository.EmployerProfileRepository;
import com.siso.profile.service.EmployerProfileService;



@RestController
@RequestMapping("/employer")
@CrossOrigin("*")
public class EmployerProfileController {
	
	@Autowired 
	EmployerProfileRepository employerprofile;
	  
	@Autowired
	EmployerProfileService profileService;
	
	 
	   
   @PostMapping("/updateprofiles")
   public EmployerProfileEntity handleFileUpload(
		   
		   
		   
           @RequestParam("userName") String userName,
           @RequestParam("GSTIN") String GSTIN,
           @RequestParam("alternateMobileNumber") String alternateMobileNumber,         
           @RequestParam("pan") String pan,
           @RequestParam("profilepic") MultipartFile profilepic
           
          		
   		
   		) throws IOException {
       
           EmployerProfileEntity fileEntity = new EmployerProfileEntity();
           fileEntity.setUserName(userName);
           fileEntity.setGSTIN(GSTIN);
           fileEntity.setAlternateMobileNumber(alternateMobileNumber);
           fileEntity.setPan(pan);          
           fileEntity.setProfilepic(profilepic.getBytes());
          

         return employerprofile.save(fileEntity);
          
		

   }
	
   
   @GetMapping("/getprofile/{profileId}")
	public EmployerProfileEntity getProfile(@PathVariable long profileId) {
	   
		return profileService.getProfile(profileId);
	   
   }
	

}
