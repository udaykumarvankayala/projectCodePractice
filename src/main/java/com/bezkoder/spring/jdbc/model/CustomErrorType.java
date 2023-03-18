package com.bezkoder.spring.jdbc.model;

public class CustomErrorType {
	private String errorMessage;
	private String successMessage;
	 
    public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
}
