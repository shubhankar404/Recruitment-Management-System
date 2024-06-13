package com.example.rms.rms.jobdecription;

import java.time.LocalDate;
import java.util.List;

import com.example.rms.rms.candidate.CandidateProfile;
import com.example.rms.rms.jobapplication.JobApplication;

import jakarta.persistence.*;

@Entity
public class JobDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String jobTitle;
    private String jobDescription;
    private String keySkillRequire;
    private String Salary;
    private Integer createdBy;
    private LocalDate createdDate;
    private Integer updatedBy;
    private LocalDate updatedDate;

    @ManyToMany
    @JoinTable(
        name = "job_application",
        joinColumns = @JoinColumn(name = "job_id"),
        inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private List<CandidateProfile> candidateProfiles;
    
    @ManyToMany(mappedBy ="jobDetails")
    private List<JobApplication>jobapplication;

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getKeySkillRequire() {
		return keySkillRequire;
	}

	public void setKeySkillRequire(String keySkillRequire) {
		this.keySkillRequire = keySkillRequire;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<CandidateProfile> getCandidateProfiles() {
		return candidateProfiles;
	}

	public void setCandidateProfiles(List<CandidateProfile> candidateProfiles) {
		this.candidateProfiles = candidateProfiles;
	}

	
    
}
