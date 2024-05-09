package com.siso.profile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class ProjectPost {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long projectId;
	private String  projectName;
	private String  budgetType;
	private Long  budgetAmount;
	private String  duration;
	private String  industry;
	private String  technologies;
	private String  projectDetails;
	@Lob
	@Column(name = "file", columnDefinition = "MEDIUMBLOB")
	private byte[]  file;
	private Long  teamSize;
	

    @ManyToOne
    @JoinColumn(name="employerId")
    private EmployerEntity employer;
    
	public ProjectPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectPost(Long projectId, String projectName, String budgetType, Long budgetAmount, String duration,
			String industry, String technologies, String projectDetails, byte[] file, Long teamSize,
			EmployerEntity employer) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.budgetType = budgetType;
		this.budgetAmount = budgetAmount;
		this.duration = duration;
		this.industry = industry;
		this.technologies = technologies;
		this.projectDetails = projectDetails;
		this.file = file;
		this.teamSize = teamSize;
		this.employer = employer;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(String budgetType) {
		this.budgetType = budgetType;
	}

	public Long getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(Long budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getTechnologies() {
		return technologies;
	}

	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}

	public String getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Long getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Long teamSize) {
		this.teamSize = teamSize;
	}

	public EmployerEntity getEmployer() {
		return employer;
	}

	public void setEmployer(EmployerEntity employer) {
		this.employer = employer;
	}

	
	
	
	
	
	
}
