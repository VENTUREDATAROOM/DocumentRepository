package com.document.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseForSearch {
	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, String customcode,HashMap<String, String> filesList) {
        Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("customcode", customcode);
            map.put("filesList", filesList);
            
           
            HttpHeaders headers2 = new HttpHeaders();
        	//headers2.add("Authorization","basic "+auth_token);
			/*
			 * headers2.add("Access-Control-Allow-Origin", "*");
			 * headers2.add("Access-Control-Allow-Methods","POST, GET, OPTIONS");
			 * headers2.add("Access-Control-Allow-Headers",
			 * "Authorization, Origin, X-Requested-With, Content-Type, Accept");
			 */
        	//HttpEntity<String> request2 = new HttpEntity<String>(headers2);
        	//MultiValueMap< String,String> params =  new LinkedMultiValueMap<>();
        	//headers2.add("auth_token", auth_token);
        	headers2.add("Content-Type","application/json");
        	ResponseEntity<Object> resp=  new ResponseEntity<Object>(map, headers2, status.value());
           return resp;
          //  return new ResponseEntity<Object>();
    }
}
