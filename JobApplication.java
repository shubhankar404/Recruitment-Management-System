package com.example.rms.rms.jobapplication;

import java.util.List;

import com.example.rms.rms.candidate.CandidateProfile;
import com.example.rms.rms.jobdecription.JobDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "job_application")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobApplicationId;

    @ManyToMany
    @JoinTable(
        name = "Jobdetails_Id_jobapplication",
        joinColumns = @JoinColumn(name = "job_application_id"),
        inverseJoinColumns = @JoinColumn(name = "job_details_id")
    )
    private List <JobDetails> jobDetails;
    @ManyToMany
    @JoinTable(
        name = "candidate_id_jobapplication",
        joinColumns = @JoinColumn(name = "job_application_id"),
        inverseJoinColumns = @JoinColumn(name = "candidate_profile_id")
    )
    private List<CandidateProfile> candidateprofile;
    
    private Long job_id;
    private Long candidate_id;
    

	public Long getJobApplicationId() {
		return jobApplicationId;
	}

	public void setJobApplicationId(Long jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}

	public Long getJobId() {
		return this.job_id;
	}

	public void setJobId(Long jobId) {
		this.job_id = jobId;
	}

	public Long getCandidateId() {
		return this.candidate_id;
	}

	public void setCandidateId(Long candidateId) {
		this.candidate_id = candidateId;
	}

	public List <JobDetails> getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(List <JobDetails> jobDetails) {
		this.jobDetails = jobDetails;
	}

	public List < CandidateProfile> getCandidateProfile() {
		return candidateprofile;
	}

	public void setCandidateProfile(List <CandidateProfile> candidateProfile) {
		this.candidateprofile = candidateProfile;
	}
	

    
}
