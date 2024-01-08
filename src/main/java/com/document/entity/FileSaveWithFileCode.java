package com.document.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="filesave_by_neelanshFC")
public class FileSaveWithFileCode {
    
	
	    @Id
	    @GeneratedValue( strategy= GenerationType.AUTO,generator="native")
	    @Column(name ="file_code_by_us")
	    Integer fileCodeByUs;
	    @Column(name ="file_code")
	    String fileCode;//should be send by API consumer
	    @Column(name ="app_code")
		private String appCode;
	    @Column(name ="saction_code")
		private String scantionCode; 
		@Column(name ="file_name")
		private String name;
		@Column(name ="file_data" )
		@Lob
		private byte[] fileInput;
		public FileSaveWithFileCode() {
			super();
			// TODO Auto-generated constructor stub
		}
		public FileSaveWithFileCode(String fileCode, String appCode, String scantionCode, String name,
				byte[] fileInput) {
			super();
			this.fileCode = fileCode;
			this.appCode = appCode;
			this.scantionCode = scantionCode;
			this.name = name;
			this.fileInput = fileInput;
		}
		public Integer getFileCodeByUs() {
			return fileCodeByUs;
		}
		public void setFileCodeByUs(Integer fileCodeByUs) {
			this.fileCodeByUs = fileCodeByUs;
		}
		public String getFileCode() {
			return fileCode;
		}
		public void setFileCode(String fileCode) {
			this.fileCode = fileCode;
		}
		public String getAppCode() {
			return appCode;
		}
		public void setAppCode(String appCode) {
			this.appCode = appCode;
		}
		public String getScantionCode() {
			return scantionCode;
		}
		public void setScantionCode(String scantionCode) {
			this.scantionCode = scantionCode;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public byte[] getFileInput() {
			return fileInput;
		}
		public void setFileInput(byte[] fileInput) {
			this.fileInput = fileInput;
		}
		
		
		
		

	
	
	
	
	
	
	
}
