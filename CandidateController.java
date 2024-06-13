package com.example.rms.rms.candidate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {

    @Autowired
    private CandidateRepository candidaterepository;
    
    @PutMapping("/candidates/updateQualification")
    public void updateQualification(@RequestParam Long candidateId , @RequestParam  String highestQualification )
    {
    	candidaterepository.updateQualification(candidateId, highestQualification);
    	
    	
    }

    
}
