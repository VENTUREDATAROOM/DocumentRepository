package com.document.contoller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.document.entity.DriverDetails;
import com.document.entity.FarmerInfoEntity;
import com.document.model.DriverDetailDTO;
import com.document.model.FarmerInfoDTO;
import com.document.model.ResponseWithObject;
import com.document.model.VegetableDetailsDTO;
import com.document.model.VegetableDetailsDTO2;
import com.document.services.FarmerService;
import com.document.services.ItemService;
import com.document.services.VegetableServices;
import com.document.services.VehcileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@Tag(name = "For Saving Details from App")
public class PostController {

	@Autowired
	ItemService itms;

	@Autowired
	FarmerService farmerService;

	@Autowired
	VehcileService vehcileService;

	@Autowired
	VegetableServices vegetableServices;

	final String successStatus = "Success";

	@PostMapping(value = "/addVegitableDetails")
	@Operation(summary = "सब्जी से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addVegetableDetails(@RequestBody VegetableDetailsDTO vegetableDetailsDTO) {

		String responseOfSave = vegetableServices.saveVegetableService(vegetableDetailsDTO);
		if (successStatus.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("vegetable saved successfully", HttpStatus.OK, "200",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR,
					"500", vegetableDetailsDTO);
		}
	}

	@PostMapping(value = "/addVegitableDetailsWithId")
	@Operation(summary = "सब्जी से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addVegitableDetailsWithId(@RequestBody VegetableDetailsDTO vegetableDetailsDTO) {

		vegetableDetailsDTO = vegetableServices.saveVegetableServiceWithId(vegetableDetailsDTO);
		if (vegetableDetailsDTO.getVegId() != 0) {
			return new ResponseWithObject().generateResponse("vegetable saved successfully", HttpStatus.OK, "200",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR,
					"500", vegetableDetailsDTO);
		}
	}

	@PostMapping(value = "/addVegitablePic", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "सब्जी ki photo ")
	public ResponseEntity<Object> uploadImage(@Valid @RequestParam("pic") MultipartFile pic,
			@RequestParam("userCode") String userCode, @RequestParam("vegId") String vegId) {

		String responseOfSave = vegetableServices.saveVegeatableImage(pic, userCode, vegId);
		if (successStatus.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("vegetable saved successfully", HttpStatus.OK, "200", "U");
		} else {
			return new ResponseWithObject().generateResponse("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR,
					"500", "N");
		}
	}

	@PostMapping("/addKisanData")
	@Operation(summary = "किसान से सम्बंधित जानकारी ")
	public ResponseEntity<Object> addItems(@Valid @RequestBody FarmerInfoDTO farmerInfoDTO) {

		String responseOfSave = farmerService.saveFarmerData(farmerInfoDTO);
		if (successStatus.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("Farmer saved successfully", HttpStatus.OK, "200",
					farmerInfoDTO);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "500", farmerInfoDTO);
		}

	}

	@PostMapping("/addDriverDetails")
	@Operation(summary = " वाहन  चालक और उससे सम्बंधित ")
	public ResponseEntity<Object> driverdetail(@Valid @RequestBody DriverDetailDTO driverDetailDTO) {

		String responseOfSave = vehcileService.saveDriverData(driverDetailDTO);
		if (successStatus.equals(responseOfSave)) {
			return new ResponseWithObject().generateResponse("driver saved successfully", HttpStatus.OK, "200",
					driverDetailDTO);
		} else {
			return new ResponseWithObject().generateResponse("not saved", HttpStatus.OK, "500", driverDetailDTO);
		}

	}

	@PostMapping("/deliveryPartnerDetails")
	@Operation(summary = "हमसे जुड़ने के लिए तैयरा ")
	public ResponseEntity<Object> uploadImage(@Valid @RequestBody FarmerInfoEntity farmarentity) {

		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "200", farmarentity);

	}

	@PostMapping("/addDriverDetailsBrief")
	@Operation(summary = " वाहन  चालक और उससे सम्बंधित ")
	public ResponseEntity<Object> driverdetail(@Valid @RequestBody DriverDetails driverdetails) {
		return new ResponseWithObject().generateResponse("provide", HttpStatus.OK, "200", driverdetails);

	}

	@PostMapping(value = "/addVegitableWithImage")
	@Operation(summary = "with single image as byte array ")
	public ResponseEntity<Object> addVegitableWithImage(@RequestBody VegetableDetailsDTO2 vegetableDetailsDTO) {

		vegetableDetailsDTO = vegetableServices.saveVegitableWithImage(vegetableDetailsDTO);
		if (vegetableDetailsDTO.getVegId() != 0) {
			return new ResponseWithObject().generateResponse("vegetable saved successfully", HttpStatus.OK, "200",
					vegetableDetailsDTO);
		} else {
			return new ResponseWithObject().generateResponse("some thing went wrong", HttpStatus.INTERNAL_SERVER_ERROR,
					"500", vegetableDetailsDTO);
		}
	}

}
