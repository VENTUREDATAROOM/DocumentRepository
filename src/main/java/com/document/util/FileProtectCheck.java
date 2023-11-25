package com.document.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileProtectCheck {

	
	public boolean encrytedOrNot(MultipartFile pfile) {
		
		
	    boolean encrypted = false;
	    PDDocument doc =null;
	    try {
	    	//InputStream fis = new ByteArrayInputStream(pfile.getBytes());
	        doc = PDDocument.load(pfile.getInputStream());
	        if(doc.isEncrypted()) {
	        	 encrypted=true;
		            doc.close();
	        }else {
	        	 encrypted=false;
	        	doc.close();
	        }
	           
	    }
	    catch(Exception e) {
	        encrypted = true;
	        
	    }
	    return encrypted;
		
		
	}
	
	
}
