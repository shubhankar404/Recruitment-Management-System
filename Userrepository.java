package com.example.rms.rms.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface Userrepository  extends JpaRepository <User,Long>{
	
	@Query("SELECT u FROM User u WHERE LOWER(u.userName) = LOWER(:userName) AND u.password = :password")
	User findByUserNameAndPassword( String userName, String password);
	
	@Transactional
    @Modifying
	@Query("UPDATE User SET password=:password WHERE emailId = :emailId AND userName=:userName")
	void resetpassword(String userName, String emailId, String password);

}
