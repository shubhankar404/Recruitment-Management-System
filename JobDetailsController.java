package com.example.rms.rms.jobdecription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobDetailsController {
	
	
	@Autowired 
	private JobRepository jobrepository;
	
	@GetMapping(value = "/jobdetails/search/{jobTitle}")
	public ResponseEntity <JobDetails> getJobdetails(@PathVariable String jobTitle)
	{
		JobDetails joblist = jobrepository.findJobDetailsByjobTitle(jobTitle);
		if(joblist != null)
		{
			return ResponseEntity.ok(joblist);
		}
		else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); 
        }
	}
	
	@GetMapping(value="/all/joblist")
	public List<JobDetails>getalljob()
	{
		List<JobDetails> jds=jobrepository.findAll();
		return jds;
	}
	
}
