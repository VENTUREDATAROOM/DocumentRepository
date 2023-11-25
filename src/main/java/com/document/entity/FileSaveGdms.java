package com.document.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GDMS_FILE_REPOSITORY")
public class FileSaveGdms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FILE_CODE_BY_US ;
	@Column(name="MODULE")
	private String module ;
	@Column(name="FILE_CODE_BY_DOMAIN")
	private String fileCodeByDomain ;
	@Column(name="FILE_DATA")
	private Byte []  fileData;
	@Column(name="FILE_NAME")
	private String fileName;
	@Column(name="FILE_CONTENT_TYPE")
	private String fileContentType;
	@Column(name="DOMAIN")
	private String domain;
	@Column(name="DATE_OF_ACTION")
	private java.sql.Timestamp  dateOfAction; 
	@Column(name="DOCUMENT_UNIQUE_KEY")
	private String documentUniqueKey;
	
	
	
	
	
	public FileSaveGdms(Long fILE_CODE_BY_US, String module, String fileCodeByDomain, Byte[] fileData, String fileName,
			String fileContentType, String domain, Timestamp dateOfAction, String documentUniqueKey) {
		super();
		FILE_CODE_BY_US = fILE_CODE_BY_US;
		this.module = module;
		this.fileCodeByDomain = fileCodeByDomain;
		this.fileData = fileData;
		this.fileName = fileName;
		this.fileContentType = fileContentType;
		this.domain = domain;
		this.dateOfAction = dateOfAction;
		this.documentUniqueKey = documentUniqueKey;
	}
	public FileSaveGdms() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getFILE_CODE_BY_US() {
		return FILE_CODE_BY_US;
	}
	public void setFILE_CODE_BY_US(Long fILE_CODE_BY_US) {
		FILE_CODE_BY_US = fILE_CODE_BY_US;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getFileCodeByDomain() {
		return fileCodeByDomain;
	}
	public void setFileCodeByDomain(String fileCodeByDomain) {
		this.fileCodeByDomain = fileCodeByDomain;
	}
	public Byte[] getFileData() {
		return fileData;
	}
	public void setFileData(Byte[] fileData) {
		this.fileData = fileData;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public java.sql.Timestamp getDateOfAction() {
		return dateOfAction;
	}
	public void setDateOfAction(java.sql.Timestamp dateOfAction) {
		this.dateOfAction = dateOfAction;
	}
	public String getDocumentUniqueKey() {
		return documentUniqueKey;
	}
	public void setDocumentUniqueKey(String documentUniqueKey) {
		this.documentUniqueKey = documentUniqueKey;
	}
	
	
	
	
	
	
}
