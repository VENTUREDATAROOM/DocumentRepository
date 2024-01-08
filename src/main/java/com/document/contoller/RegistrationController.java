package com.document.contoller;





import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.document.model.ProfileModel;
import com.document.model.RegisterModal;
import com.document.model.Response2;
import com.document.model.ResponseWithList;
import com.document.model.ResponseWithObject;
import com.document.services.RegistrationService;
import com.document.util.AppConstants;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
@Tag(name = "Registration-API")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

	@PostMapping(value = "/registerToApp")
	public ResponseEntity<?> registration(@Valid @RequestBody RegisterModal userMstr) {

		String userStatus = registrationService.findByUsername(userMstr);
		if ("A".equals(userStatus)) {
			return Response2.generateResponse("User name  already available", HttpStatus.OK, "201");
		} else {
			String regResponse = registrationService.registerByApplication(userMstr);
			log.info("Registration status of the user {} ", regResponse);
			if (regResponse.equalsIgnoreCase("existing")) {
				return Response2.generateResponse("mobile number already exist ", HttpStatus.FOUND, "302");
			} else if (regResponse.equalsIgnoreCase("Error")) {
				return Response2.generateResponse("Something wnet wrong", HttpStatus.OK, "200");
			} else {
				return Response2.generateResponse("Successfully register", HttpStatus.OK, "200");
			}
		}
	}
	@PostMapping(value = "/profileData")
	public ResponseEntity<?> profileData(String userCode)
			{

		ProfileModel pro = registrationService.getProfileData(userCode);
		if (pro != null) {
			return new ResponseWithObject().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200", pro);
		} else {
			return new ResponseWithObject().generateResponse("NA", HttpStatus.NOT_FOUND, "200", pro);
		}

	}
	@GetMapping(value="/findprofile")
	public ResponseEntity<?> getAllProfile() 
	{
          
	         List<ProfileModel> pro=registrationService.getAllProfiles();
		     if(pro!=null)
		     {
		    	 return new ResponseWithList().generateResponse(AppConstants.SUCCESSSTATUS, HttpStatus.OK, "200", pro);
			 }
		     else
		     {
		 	return new ResponseWithList().generateResponse("NA", HttpStatus.NOT_FOUND, "200", pro);
		     }
	}
}
	
	
