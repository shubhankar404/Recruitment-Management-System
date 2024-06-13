package com.example.rms.rms.jobapplication;

public class JobApplicationDTO {
	private Long jobApplicationId;
    private String userName;
    private String jobTitle;
    
    public JobApplicationDTO(Long jobApplicationId, String userName, String jobTitle) {
        this.jobApplicationId = jobApplicationId;
        this.userName = userName;
        this.jobTitle = jobTitle;
    }
	public Long getJobApplicationId() {
		return jobApplicationId;
	}
	public void setJobApplicationId(Long jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
    
    

}
