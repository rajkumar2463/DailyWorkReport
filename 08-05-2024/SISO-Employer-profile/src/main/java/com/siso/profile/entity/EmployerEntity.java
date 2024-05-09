package com.siso.profile.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class EmployerEntity {
	
	@Id
	private String employerId;
	private String nameOftheCompany;
	private String uRL;
	private String contactPerson;
	private String companyEmail;
	private String designation;
	private String mobileNumber;
	private String location;
	private String type;	
	private String password;
	private String emailOtp;
	private String mobileOtp;
	private String enteredOtp;
	private String enteredEmailOtp;
    private String noOfEmployees;
	
	private String userName;
	private String GSTIN;
	private String alternateMobileNumber;
	private String pan;
	
	
	
	@Lob
	@Column(name = "profilepic", columnDefinition = "MEDIUMBLOB")
	private byte[] profilepic;
	
	
	
	private String newPassword;
	
	private String confirmNewPassword;
	
	private String phoneOtp;
	
	private String enteredPhoneOtp;

	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employer", cascade = CascadeType.ALL)
	private List<JobPostEntity> jobposts;
	
	public EmployerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	







	public EmployerEntity(String employerId, String nameOftheCompany, String uRL, String contactPerson,
			String companyEmail, String designation, String mobileNumber, String password,String location, String type, String emailOtp,
			String mobileOtp,String enteredOtp, String enteredEmailOtp,String noOfEmployees,List<JobPostEntity> jobposts,String newPassword,String confirmNewPassword, String phoneOtp, String enteredPhoneOtp) {
		super();
		this.employerId = employerId;
		this.nameOftheCompany = nameOftheCompany;
		this.uRL = uRL;
		this.contactPerson = contactPerson;
		this.companyEmail = companyEmail;
		this.designation = designation;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.location = location;
		this.type = type;
		this.emailOtp = emailOtp;
		this.mobileOtp = mobileOtp;
		this.enteredOtp = enteredOtp;
		this.enteredEmailOtp = enteredEmailOtp;
		this.noOfEmployees = noOfEmployees;
		this.jobposts = jobposts;
		this.newPassword = newPassword;
		this.confirmNewPassword = confirmNewPassword;
		this.phoneOtp = phoneOtp;
		this.enteredPhoneOtp = enteredPhoneOtp;

	}
	


	public EmployerEntity(String userName, String gSTIN, String alternateMobileNumber, String pan, byte[] profilepic) {
		super();
		this.userName = userName;
		GSTIN = gSTIN;
		this.alternateMobileNumber = alternateMobileNumber;
		this.pan = pan;
		this.profilepic = profilepic;
	}
	
	
	

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}






	public String getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(String noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGSTIN() {
		return GSTIN;
	}

	public void setGSTIN(String gSTIN) {
		GSTIN = gSTIN;
	}

	public String getAlternateMobileNumber() {
		return alternateMobileNumber;
	}

	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public byte[] getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(byte[] profilepic) {
		this.profilepic = profilepic;
	}

	public String getEnteredOtp() {
		return enteredOtp;
	}

	public void setEnteredOtp(String enteredOtp) {
		this.enteredOtp = enteredOtp;
	}

	public String getEnteredEmailOtp() {
		return enteredEmailOtp;
	}

	public void setEnteredEmailOtp(String enteredEmailOtp) {
		this.enteredEmailOtp = enteredEmailOtp;
	}

	public String getEmployerId() {
		return employerId;
	}

	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}

	public String getNameOftheCompany() {
		return nameOftheCompany;
	}

	public void setNameOftheCompany(String nameOftheCompany) {
		this.nameOftheCompany = nameOftheCompany;
	}

	

	public String getuRL() {
		return uRL;
	}

	public void setuRL(String uRL) {
		this.uRL = uRL;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}

	public String getMobileOtp() {
		return mobileOtp;
	}

	public void setMobileOtp(String mobileOtp) {
		this.mobileOtp = mobileOtp;
	}


	public List<JobPostEntity> getJobposts() {
		return jobposts;
	}


	public void setJobposts(List<JobPostEntity> jobposts) {
		this.jobposts = jobposts;
	}








	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}








	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}








	public String getPhoneOtp() {
		return phoneOtp;
	}








	public void setPhoneOtp(String phoneOtp) {
		this.phoneOtp = phoneOtp;
	}








	public String getEnteredPhoneOtp() {
		return enteredPhoneOtp;
	}








	public void setEnteredPhoneOtp(String enteredPhoneOtp) {
		this.enteredPhoneOtp = enteredPhoneOtp;
	}
	
	
	
	

	

}
