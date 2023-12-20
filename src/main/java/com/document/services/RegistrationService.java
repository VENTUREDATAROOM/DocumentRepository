package com.document.services;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.document.entity.GdmsApiUsers;
import com.document.model.ProfileModel;
import com.document.model.RegisterModal;
import com.document.repo.GdmsApiUserRepo;

@Service
public class RegistrationService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	ModelMapper mapper;

	@Autowired
	GdmsApiUserRepo gdmsApiUserRepo;

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RegistrationService.class);

	public String registerByMobileApplication(RegisterModal usrMstrDto) {

		try {
			GdmsApiUsers gdmsApiUsers = mapper.map(usrMstrDto, GdmsApiUsers.class);
			gdmsApiUsers.setPassword(bcryptEncoder.encode(usrMstrDto.getPassword()));
			gdmsApiUsers.setUserstatus("Y");
			gdmsApiUsers.setName(usrMstrDto.getMobileno());
			gdmsApiUsers.setDateOfCreation(LocalDate.now());
			gdmsApiUsers.setEmail(usrMstrDto.getEmail());
			gdmsApiUsers.setCompanyName(usrMstrDto.getCompanyname());
			gdmsApiUserRepo.save(gdmsApiUsers);
			return "Success";
		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return "Error";
		}

	}

	public String findByMobile(@Valid RegisterModal userMstr) {

		try {
			Optional<GdmsApiUsers> mobileCheck = gdmsApiUserRepo.findByMobileNo(userMstr.getMobileno());
			if (mobileCheck.isPresent()) {
				return "A";
			} else {
				return "NA";
			}

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return  "A";
}
}

	public ProfileModel getProfileData(String userCode)
	{
		ProfileModel pro = new ProfileModel();
		try {

			Optional<GdmsApiUsers> users = gdmsApiUserRepo.findByMobileNo(userCode);
			if (users.isPresent()) {
				pro.setEmail(users.get().getEmail());
				pro.setMobileNumber(userCode);
				
				pro.setName(users.get().getName());
				pro.setFlagofuser(users.get().getFlgOfUser());
				pro.setAadharNumber(users.get().getAadharNumber());
						
			}

			return pro;

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
			return pro;
		}

	}
	

}
