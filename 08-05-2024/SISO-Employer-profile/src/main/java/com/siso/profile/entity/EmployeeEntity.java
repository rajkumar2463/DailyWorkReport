package com.siso.profile.entity;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "employee")

public class EmployeeEntity {

	@Id	
	private String employeeId;

	@Column
	private String userName;
	@Column
	private String firstName;
	
	@Column
	private String lastName;

	private String email;
	
	@Column
	private String emailOtp;
	
	@Column
	private String enterOtp;
	
	
	@Column
	private String fileName;
	
	
	private String phone;

	@Column
	private String phoneOtp;
	
	@Column
	private String alternateMobile;
	private String password;
	private String newPassword;
	private String confirmNewPassword;
	private String gender;
	private Date dob;
	private String designation;
	private String jobRole;

	@Column
	private String registerAs;
	@Column
	private String workStatus;
	@Column
	private String benchStatus;
	
	@Column
	private String modeOfJob;

	@Column
	private String typeOfJob;
	
	
	private Integer years;
	private Integer months;

	@Column
	private Double currentSalary;
	


	@Column
	private Double expectedSalary1;

	@Column
	private Double expectedSalary2;

	@Lob
	@Column(name = "resume", columnDefinition = "MEDIUMBLOB")
	private byte[] resume;

	@Column
	private String resumeDescription;

	@Lob
	private Byte[] image;
	
	@ManyToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<JobPostEntity> applyjob;


	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmployeeEntity(String employeeId, String userName, String firstName, String lastName, String email,
			String emailOtp, String enterOtp, String fileName, String phone, String phoneOtp, String alternateMobile,
			String password, String newPassword, String confirmNewPassword, String gender, Date dob, String designation,
			String jobRole, String registerAs, String workStatus, String benchStatus, String modeOfJob,
			String typeOfJob, Integer years, Integer months, Double currentSalary, Double expectedSalary1,
			Double expectedSalary2, byte[] resume, String resumeDescription, Byte[] image,
			List<JobPostEntity> applyjob) {
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.emailOtp = emailOtp;
		this.enterOtp = enterOtp;
		this.fileName = fileName;
		this.phone = phone;
		this.phoneOtp = phoneOtp;
		this.alternateMobile = alternateMobile;
		this.password = password;
		this.newPassword = newPassword;
		this.confirmNewPassword = confirmNewPassword;
		this.gender = gender;
		this.dob = dob;
		this.designation = designation;
		this.jobRole = jobRole;
		this.registerAs = registerAs;
		this.workStatus = workStatus;
		this.benchStatus = benchStatus;
		this.modeOfJob = modeOfJob;
		this.typeOfJob = typeOfJob;
		this.years = years;
		this.months = months;
		this.currentSalary = currentSalary;
		this.expectedSalary1 = expectedSalary1;
		this.expectedSalary2 = expectedSalary2;
		this.resume = resume;
		this.resumeDescription = resumeDescription;
		this.image = image;
		this.applyjob = applyjob;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmailOtp() {
		return emailOtp;
	}


	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}


	public String getEnterOtp() {
		return enterOtp;
	}


	public void setEnterOtp(String enterOtp) {
		this.enterOtp = enterOtp;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPhoneOtp() {
		return phoneOtp;
	}


	public void setPhoneOtp(String phoneOtp) {
		this.phoneOtp = phoneOtp;
	}


	public String getAlternateMobile() {
		return alternateMobile;
	}


	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}


	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getJobRole() {
		return jobRole;
	}


	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}


	public String getRegisterAs() {
		return registerAs;
	}


	public void setRegisterAs(String registerAs) {
		this.registerAs = registerAs;
	}


	public String getWorkStatus() {
		return workStatus;
	}


	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}


	public String getBenchStatus() {
		return benchStatus;
	}


	public void setBenchStatus(String benchStatus) {
		this.benchStatus = benchStatus;
	}


	public String getModeOfJob() {
		return modeOfJob;
	}


	public void setModeOfJob(String modeOfJob) {
		this.modeOfJob = modeOfJob;
	}


	public String getTypeOfJob() {
		return typeOfJob;
	}


	public void setTypeOfJob(String typeOfJob) {
		this.typeOfJob = typeOfJob;
	}


	public Integer getYears() {
		return years;
	}


	public void setYears(Integer years) {
		this.years = years;
	}


	public Integer getMonths() {
		return months;
	}


	public void setMonths(Integer months) {
		this.months = months;
	}


	public Double getCurrentSalary() {
		return currentSalary;
	}


	public void setCurrentSalary(Double currentSalary) {
		this.currentSalary = currentSalary;
	}


	public Double getExpectedSalary1() {
		return expectedSalary1;
	}


	public void setExpectedSalary1(Double expectedSalary1) {
		this.expectedSalary1 = expectedSalary1;
	}


	public Double getExpectedSalary2() {
		return expectedSalary2;
	}


	public void setExpectedSalary2(Double expectedSalary2) {
		this.expectedSalary2 = expectedSalary2;
	}


	public byte[] getResume() {
		return resume;
	}


	public void setResume(byte[] resume) {
		this.resume = resume;
	}


	public String getResumeDescription() {
		return resumeDescription;
	}


	public void setResumeDescription(String resumeDescription) {
		this.resumeDescription = resumeDescription;
	}


	public Byte[] getImage() {
		return image;
	}


	public void setImage(Byte[] image) {
		this.image = image;
	}


	public List<JobPostEntity> getApplyjob() {
		return applyjob;
	}


	public void setApplyjob(List<JobPostEntity> applyjob) {
		this.applyjob = applyjob;
	}

	




		
	}

	

			
	

