package com.document.model;

public class FileResponseModel {

	private String  Status;
	private String fileCode;
	private String message;
	
	public FileResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileResponseModel(String status, String fileCode, String message) {
		super();
		Status = status;
		this.fileCode = fileCode;
		this.message = message;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
