package com.example.rms.rms.jobapplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{
	
	@Query("SELECT NEW com.example.rms.rms.jobapplication.JobApplicationDTO(ja.jobApplicationId, u.userName, jd.jobTitle )FROM JobApplication ja JOIN CandidateProfile cp ON ja.candidate_id = cp.candidateId JOIN JobDetails jd ON ja.job_id = jd.jobId JOIN User u ON cp.user_id = u.UserId WHERE cp.candidateId = :candidateId")	
	List<JobApplicationDTO>findAllApplication(Long candidateId);
}
