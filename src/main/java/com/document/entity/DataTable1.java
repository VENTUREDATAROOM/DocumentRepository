package com.document.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="filesave_by_neelansh")
public class DataTable1 {
    
	
	    @Id
	    @GeneratedValue( strategy= GenerationType.AUTO,
			    generator="native")
	    @Column(name ="file_code")
	     Integer fileCode;
	    @Column(name ="app_code")
		private String appCode;
	    @Column(name ="saction_code")
		private String scantionCode; 
		@Column(name ="file_name")
		private String name;
		@Column(name ="file_data" )
		@Lob
		private byte[] fileInput;
		public DataTable1() {
			super();
			// TODO Auto-generated constructor stub
		}
		public DataTable1(Integer fileCode, String appCode, String scantionCode, String name, byte[] fileInput) {
			super();
			this.fileCode = fileCode;
			this.appCode = appCode;
			this.scantionCode = scantionCode;
			this.name = name;
			this.fileInput = fileInput;
		}
		
		
		public DataTable1(String appCode, String scantionCode, String name, byte[] fileInput) {
			super();
			this.appCode = appCode;
			this.scantionCode = scantionCode;
			this.name = name;
			this.fileInput = fileInput;
		}
		public Integer getFileCode() {
			return fileCode;
		}
		public void setFileCode(Integer fileCode) {
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
