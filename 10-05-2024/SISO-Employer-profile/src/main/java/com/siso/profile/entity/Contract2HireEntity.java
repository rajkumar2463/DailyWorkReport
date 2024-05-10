package com.siso.profile.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Contract2HireEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long c2HId;
	
	private String   skillsRequired;
	private Long    teamSize;
	private String   location;
	private String   c2hType;
	private String   c2hExpiry;
	private String    contactPerson;
	private String   email;
	private String    phoneNumber;
	private String   role;
	private String   workStatus;
	private Long   number;
	
	
	 @ManyToOne
	 @JoinColumn(name="employerId")
	 private EmployerEntity employer;
	    
	    @ManyToMany
		private List<EmployeeEntity>employee;
	    
	public Contract2HireEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Contract2HireEntity(Long c2hId, String skillsRequired, Long teamSize, String location, String c2hType,
			String c2hExpiry, String contactPerson, String email, String phoneNumber, String role, String workStatus,
			Long number, EmployerEntity employer, List<EmployeeEntity> employee) {
		super();
		c2HId = c2hId;
		this.skillsRequired = skillsRequired;
		this.teamSize = teamSize;
		this.location = location;
		this.c2hType = c2hType;
		this.c2hExpiry = c2hExpiry;
		this.contactPerson = contactPerson;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.workStatus = workStatus;
		this.number = number;
		this.employer = employer;
		this.employee = employee;
	}




	public Long getC2HId() {
		return c2HId;
	}

	public void setC2HId(Long c2hId) {
		c2HId = c2hId;
	}

	public String getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public Long getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Long teamSize) {
		this.teamSize = teamSize;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getC2hType() {
		return c2hType;
	}

	public void setC2hType(String c2hType) {
		this.c2hType = c2hType;
	}

	public String getC2hExpiry() {
		return c2hExpiry;
	}

	public void setC2hExpiry(String c2hExpiry) {
		this.c2hExpiry = c2hExpiry;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public EmployerEntity getEmployer() {
		return employer;
	}

	public void setEmployer(EmployerEntity employer) {
		this.employer = employer;
	}

	public List<EmployeeEntity> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeEntity> employee) {
		this.employee = employee;
	}
	
	
	
	
}
