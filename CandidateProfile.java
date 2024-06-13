package com.example.rms.rms.candidate;

import java.time.LocalDate;
import java.util.List;

import com.example.rms.rms.User.User;
import com.example.rms.rms.jobapplication.JobApplication;

import jakarta.persistence.*;

@Entity
public class CandidateProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "UserId", insertable = false, updatable = false)
   private User user;
    
    @ManyToMany(mappedBy ="candidateprofile")
    private List<JobApplication>jobapplication;
    
    
    private long user_id;

    private String highestQualification;
    private String cv;
    private String photo;
    private Integer createdBy;
    private LocalDate createdDate;
    private Integer updatedBy;
    private LocalDate updatedDate;

    // Getters and Setters

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public long getUser() {
        //return user.getUserId();
    	return this.user_id;
    }

    public void setUser(long userid) {
        this.user_id = userid;
    
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
}
