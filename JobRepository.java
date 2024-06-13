package com.example.rms.rms.jobdecription;



import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobDetails, Long >{
	
	JobDetails findJobDetailsByjobTitle(String jobTitle);

}
