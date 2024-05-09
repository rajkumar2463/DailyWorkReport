package com.siso.profile.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class JobPostEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	    private Long jobPostId;   
	    private String jobRole;
	    private String company;
	    private String requiredExperience;
	    private String workLocation;
	    private String jobDescription;
	    private String requiredSkills;
	    private String responsibilities;
	    private String lastApplyDate;
	    private String datePosted;
	    private String postedby;
	    private String modeOfJob;
	    private String contact;
	    private String category;
	    private String type;
	    private String ctc;
	    
	    @ManyToOne
	    private EmployerEntity employer;
	    
	    @ManyToMany
		private List<EmployeeEntity>employee;
	    
	    
		public JobPostEntity() {
			super();
			// TODO Auto-generated constructor stub
		}


		public JobPostEntity(Long jobPostId, String jobRole, String company, String requiredExperience,
				String workLocation, String jobDescription, String requiredSkills, String responsibilities,
				String lastApplyDate, String datePosted, String postedby, String modeOfJob, String contact,
				String category, String type, String ctc, EmployerEntity employer, List<EmployeeEntity> employee) {
			super();
			this.jobPostId = jobPostId;
			this.jobRole = jobRole;
			this.company = company;
			this.requiredExperience = requiredExperience;
			this.workLocation = workLocation;
			this.jobDescription = jobDescription;
			this.requiredSkills = requiredSkills;
			this.responsibilities = responsibilities;
			this.lastApplyDate = lastApplyDate;
			this.datePosted = datePosted;
			this.postedby = postedby;
			this.modeOfJob = modeOfJob;
			this.contact = contact;
			this.category = category;
			this.type = type;
			this.ctc = ctc;
			this.employer = employer;
			this.employee = employee;
		}


		public Long getJobPostId() {
			return jobPostId;
		}


		public void setJobPostId(Long jobPostId) {
			this.jobPostId = jobPostId;
		}


		public String getJobRole() {
			return jobRole;
		}


		public void setJobRole(String jobRole) {
			this.jobRole = jobRole;
		}


		public String getCompany() {
			return company;
		}


		public void setCompany(String company) {
			this.company = company;
		}


		public String getRequiredExperience() {
			return requiredExperience;
		}


		public void setRequiredExperience(String requiredExperience) {
			this.requiredExperience = requiredExperience;
		}


		public String getWorkLocation() {
			return workLocation;
		}


		public void setWorkLocation(String workLocation) {
			this.workLocation = workLocation;
		}


		public String getJobDescription() {
			return jobDescription;
		}


		public void setJobDescription(String jobDescription) {
			this.jobDescription = jobDescription;
		}


		public String getRequiredSkills() {
			return requiredSkills;
		}


		public void setRequiredSkills(String requiredSkills) {
			this.requiredSkills = requiredSkills;
		}


		public String getResponsibilities() {
			return responsibilities;
		}


		public void setResponsibilities(String responsibilities) {
			this.responsibilities = responsibilities;
		}


		public String getLastApplyDate() {
			return lastApplyDate;
		}


		public void setLastApplyDate(String lastApplyDate) {
			this.lastApplyDate = lastApplyDate;
		}


		public String getDatePosted() {
			return datePosted;
		}


		public void setDatePosted(String datePosted) {
			this.datePosted = datePosted;
		}


		public String getPostedby() {
			return postedby;
		}


		public void setPostedby(String postedby) {
			this.postedby = postedby;
		}


		public String getModeOfJob() {
			return modeOfJob;
		}


		public void setModeOfJob(String modeOfJob) {
			this.modeOfJob = modeOfJob;
		}


		public String getContact() {
			return contact;
		}


		public void setContact(String contact) {
			this.contact = contact;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public String getCtc() {
			return ctc;
		}


		public void setCtc(String ctc) {
			this.ctc = ctc;
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
