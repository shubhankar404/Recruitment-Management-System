package com.example.rms.rms.User;



import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rms.rms.candidate.CandidateProfile;
import com.example.rms.rms.candidate.CandidateRepository;

//import jakarta.transaction.Transactional;

@RestController

public class UserController {
	
	@Autowired
	private Userrepository userrepository;
	@Autowired
	private CandidateRepository candidaterepository;
	
	@PostMapping(value = "/user/add")
	public ResponseEntity <String> adduserdetails(@RequestBody User user)
	{
		
		userrepository.save(user);
		User user1= userrepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		addCandidate(user1);
//		return user1.getUserId();
		return ResponseEntity.ok("User Add sucess");
		
		
	   
		
	}
	
	public void addCandidate(User  user)
	{
		CandidateProfile candidate = new CandidateProfile();
		candidate.setUser(user.getUserId());
		candidaterepository.save(candidate);	
	}
	
//	@GetMapping(value = "/user/login/{userName}/{password}")
//    public ResponseEntity<User> login(@PathVariable String userName, @PathVariable String password) {
//        User user = userrepository.findByUserNameAndPassword(userName, password);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); 
//        }
//    }
	
	@GetMapping(value = "/user/login/{userName}/{password}")
    public ResponseEntity<CandidateProfile> login(@PathVariable String userName, @PathVariable String password) {
        User user = userrepository.findByUserNameAndPassword(userName, password);
        if (user != null) {            
        	CandidateProfile candidate = findCandidate(user);
        	return ResponseEntity.ok(candidate);
        } else {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); 
        	
        }
    }
	
	public CandidateProfile findCandidate(User  user)
	{
//		CandidateProfile candidate = new CandidateProfile();
		//candidate.setUser(user.getUserId());
		CandidateProfile candidate = candidaterepository.findCandidateByUserId(user.getUserId());
		return candidate;
	}
	
	// ResetPassword api
	@PutMapping(value ="/reset/password")
	public void resetPassword(@RequestParam String userName, @RequestParam String emailId, @RequestParam String password)
	{
		userrepository.resetpassword(userName, emailId, password);
		
	}
	

}
