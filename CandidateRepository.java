package com.example.rms.rms.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;



public interface CandidateRepository  extends JpaRepository <CandidateProfile,Long>{

	@Query("SELECT c FROM CandidateProfile c WHERE c.user_id = :user_id")
	CandidateProfile findCandidateByUserId( Long user_id);
	
	@Transactional
    @Modifying
    @Query("UPDATE CandidateProfile c SET c.highestQualification = :highestQualification WHERE c.candidateId = :candidateId ")
	void updateQualification(Long candidateId, String highestQualification);
}