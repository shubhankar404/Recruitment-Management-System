package com.example.rms.rms.User;

import com.example.rms.rms.candidate.CandidateProfile;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;
    
    @Column(name = "user_name")
    private String userName;
    private String password;
    @Column(name = "mobile_number")
    private Long mobileNumber;
    @Column(name="email_id")
    private String emailId;
    private String fatherName;
    private String address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private CandidateProfile candidateProfile;

    // Getters and Setters

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CandidateProfile getCandidateProfile() {
        return candidateProfile;
    }

    public void setCandidateProfile(CandidateProfile candidateProfile) {
        this.candidateProfile = candidateProfile;
        if (candidateProfile != null) {
            candidateProfile.setUser(candidateProfile.getUser());
        }
    }
}
