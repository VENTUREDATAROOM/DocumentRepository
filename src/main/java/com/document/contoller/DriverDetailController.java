package com.document.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.document.model.DriverDetailDTO;
import com.document.model.ResponseWithObject;
import com.document.services.DriverDetailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Dashboardrelated API")

public class DriverDetailController {

	@Autowired
	DriverDetailService driverdetailservice;

	@GetMapping("/getDriverByUserCode")
	@Operation(summary = "ड्राईवर कोड से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsByUserCode(@RequestParam("userCode") String userCode) {

		DriverDetailDTO driverdetaildto = driverdetailservice.findByuserCode(userCode);
		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", driverdetaildto);
	}

	@GetMapping("/getDriverByMobileno")
	@Operation(summary = "ड्राईवर के मोबाइल न. से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsBydriverNumber(@RequestParam("driverNumber") String driverNumber) {

		DriverDetailDTO driverdetaildto = driverdetailservice.findByDriverbydriverNumber(driverNumber);
		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", driverdetaildto);
	}

	@GetMapping("/getDriverByarea")
	@Operation(summary = "ड्राईवर की गाड़ी चलाने वाले क्षेत्र से ड्राईवर की जानकारी निकाले ")
	public ResponseEntity<?> getDriverDetailsByarea(@RequestParam("area") String area) {

		DriverDetailDTO driverdetaildto = driverdetailservice.findByDriverbydriverarea(area);
		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "", driverdetaildto);
	}

	@GetMapping("/getDriverCountByUserCode")
	@Operation(summary = "userCode ke hisab se driver ka count nikale ")
	public ResponseEntity<?> getDriverCountByUserCode(@RequestParam("userCode") String userCode) {

		Long count = driverdetailservice.findVegetableCount(userCode);

		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "200", count);
	}

}
