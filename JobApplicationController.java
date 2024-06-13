package com.example.rms.rms.jobapplication;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    // Job apply Api create here
    @PostMapping("/job/apply")
    public ResponseEntity<String> applyForJob(@RequestBody JobApplication jobapplication) {
        Long jobId = jobapplication.getJobId();
        Long candidateId = jobapplication.getCandidateId();
        JobApplication jobApplication = new JobApplication();
        
        jobApplication.setJobId(jobId);
        jobApplication.setCandidateId(candidateId);

        jobApplicationRepository.save(jobApplication);

        return ResponseEntity.ok("Application submitted successfully!");
    }
    
    @GetMapping("/get/applications")
    public List<JobApplicationDTO> getApplicationsForCurrentUser(@RequestParam Long candidateId) {
        // Fetch job applications for the current user (candidate)
        List<JobApplicationDTO> applications = jobApplicationRepository.findAllApplication(candidateId);
        return applications;
    }
    
}
