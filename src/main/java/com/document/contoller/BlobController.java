package com.document.contoller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.document.entity.FileSaveWithFileCode;
import com.document.model.Response2;
import com.document.model.ResponseForSearch;
import com.document.model.ResponseWithFCDwonload;
import com.document.model.ResponseWithFCDwonload2;
import com.document.model.ResponseWithFileCode;
import com.document.services.BlobService;
import com.document.util.FileProtectCheck;

import io.swagger.v3.oas.annotations.tags.Tag;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@Tag(name="File-Controller")
public class BlobController {

	@Autowired
	BlobService bService;

	@Autowired
	FileProtectCheck fpc;

	
	List<String> allowedContentType= Arrays.asList("application/pdf","application/vnd.openxmlformats-officedocument.wordprocessingml.document","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet","application/rtf","application/vnd.ms-excel");
	
	@GetMapping(value = "/hi")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("its in air");
	}

	@PostMapping(value = "/singlefile")
	public ResponseEntity<Object> ImageSaver(@RequestParam("appCode") String appCode,@RequestParam("fileCode") String fileCode ,
			@RequestParam("file") MultipartFile file,
			@RequestParam("moduleCode") String moduleCode, ModelMap map) {
		System.out.println(file.getOriginalFilename());
		if (!file.isEmpty()) {
			if (!allowedContentType.contains(file.getContentType())) {
			     return Response2.generateResponse(file.getOriginalFilename() +", is not a valid file", HttpStatus.OK, "003");	
			}
			if(file.getContentType().equals("application/pdf")) {
				boolean b= fpc.encrytedOrNot((file));
				System.out.println(b);
				if (b) {// case of encryption
					return Response2.generateResponse("Kindly provide  the key for:-" + file.getOriginalFilename(),HttpStatus.OK, "001");
				}
			}	
			String result = bService.singlefile(appCode, file, moduleCode,map);
			if (result.equals("D")) {
				HashMap<String,String> hash = new HashMap<>();
				hash.put(fileCode,file.getContentType());
				return ResponseWithFileCode.generateResponse("Success", HttpStatus.OK, "200",hash);
			} else {
				return ResponseEntity.internalServerError().body("something went wrong");
			}
		} else {
			return Response2.generateResponse("Select at least one file for process", HttpStatus.OK, "002");
		}

	}
	@PostMapping(value = "/mFI2")
	public ResponseEntity<Object> ImageSaverArray3(@RequestParam("appCode") String appCode,
			@RequestParam("file") MultipartFile[] dataSet, @RequestParam("moduleCode") String moduleCode,
			@RequestParam("fileCode") String[] fileCode, ModelMap map) {

		HashMap<String, MultipartFile> dataToBeSaved = new HashMap<>();
		Map<String, String> dbResponse = new HashMap<>();
		System.out.println("number of files :" + dataSet.length + ",for appcode->" + appCode + " with "
				+ fileCode.length + "of filecode");
		try {
			
			if (dataSet.length != 0) {
				//ArrayList<MultipartFile> listofdataSet = (ArrayList<MultipartFile>) Arrays.asList(dataSet);
			
			
				for (int i = 0; i < dataSet.length; i++) {
					//if (!dataSet[i].getContentType().equals("application/pdf")) {
					/*
					 * if (!dataSet[i].getContentType().equals("application/pdf")) { return
					 * Response2.generateResponse(dataSet[i].getOriginalFilename() +
					 * ", is not a valid file", HttpStatus.OK, "003"); }
					 */
					
					if (!allowedContentType.contains(dataSet[i].getContentType())) {
					     return Response2.generateResponse(dataSet[i].getOriginalFilename() +", is not a valid file", HttpStatus.OK, "003");	
					}
					
					System.out.println(dataSet[i].getContentType());
					System.out.println("inside the loop for check " + dataSet[i].getOriginalFilename());
					if (dataSet[i] == null) {
						dbResponse.put(fileCode[i], "Closed");
					} else {
						if (!dataSet[i].isEmpty()) {
							boolean b=false;
							if(dataSet[i].getContentType().equals("application/pdf")) {
								 b= fpc.encrytedOrNot((dataSet[i]));
								System.out.println(b);
								
							}					
							if (b) {// case of encryption
								return Response2.generateResponse("Kindly provide  the key for:-" + dataSet[i].getOriginalFilename(),
										HttpStatus.OK, "001");
							} else {

								dataToBeSaved.put(fileCode[i], dataSet[i]);
							}
						} else {
							dbResponse.put(fileCode[i], "Closed");
						}
					}
				}
				// service call for saving data
				dbResponse = bService.insertWithFileCode(appCode, dataToBeSaved, moduleCode);
				// useless for this approach
				if (dbResponse.containsValue("D")) {

					return ResponseWithFileCode.generateResponse("Success", HttpStatus.OK, "200",
							(HashMap<String, String>) dbResponse);
				} else {
					return Response2.generateResponse("Success", HttpStatus.INTERNAL_SERVER_ERROR, "500");

				}

			} else {
				return Response2.generateResponse("Select at least one file for process", HttpStatus.OK, "002");
			}

		} catch (Exception r) {

			return Response2.generateResponse(r.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "500");
		}

	}

	@PostMapping(value = "/mFI3")
	public ResponseEntity<Object> ImageSaverArray4(@RequestParam("appCode") String appCode,
			@RequestParam("file") List<MultipartFile> dataSet,  @RequestParam("moduleCode") String moduleCode,
			@RequestParam("fileCode") List<String> fileCode, ModelMap map) {

		HashMap<String, MultipartFile> dataToBeSaved = new HashMap<>();
		Map<String, String> dbResponse = new HashMap<>();
		Map<String, String> dbResponseFromdb = new HashMap<>();
		System.out.println("number of files :" + dataSet.size() + ",for appcode->" + appCode + " with "
				+ fileCode.size() + " filecode's");
		try {

			if (dataSet.size() != 0) {
				for (int i = 0; i < dataSet.size(); i++) {
				if (dataSet.get(i) == null) {
						dbResponse.put(fileCode.get(i), "Closed");
					} else {
						if (!dataSet.get(i).isEmpty()) {

						
							if(allowedContentType.contains(dataSet.get(i).getContentType())){
								boolean b=false;
								if(dataSet.get(i).getContentType().equals("application/pdf")) {
									 b= fpc.encrytedOrNot((dataSet.get(i)));
									System.out.println(b);
									
								}
								if (b) {
									return Response2.generateResponse(
											"Kindly provide  the key for:-" + dataSet.get(i).getOriginalFilename(),HttpStatus.OK, "001");
								} else {

									dataToBeSaved.put(fileCode.get(i), dataSet.get(i));
								}
							} else {
								return Response2.generateResponse("Kindly select a valid type:-" + dataSet.get(i).getOriginalFilename(),HttpStatus.OK, "001");
							}

						} else {
							dbResponse.put(fileCode.get(i), "Closed");
						}
					}
				}
				// service call for saving data
				if (dbResponse.size() > 0 || dataToBeSaved.size() > 0) {
					dbResponseFromdb = bService.insertWithFileCode(appCode, dataToBeSaved, moduleCode);
					// useless for this approach
					dbResponse.putAll(dbResponseFromdb);
					if (dbResponseFromdb.containsValue("D")) {

						return ResponseWithFileCode.generateResponse("Success", HttpStatus.OK, "200",
								(HashMap<String, String>) dbResponse);
					} else {
						return ResponseWithFileCode.generateResponse("Success response", HttpStatus.OK, "011",
								(HashMap<String, String>) dbResponse);

					}
				} else {

					return Response2.generateResponse("Select at least one file for process", HttpStatus.OK, "002");
				}

			} else {
				return Response2.generateResponse("Select at least one file for process", HttpStatus.OK, "002");
			}

		} catch (Exception r) {

			return Response2.generateResponse(r.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "500");
		}

	}


	@PostMapping(value = "/dowloadContent")
	public ResponseEntity<Object> ApiForDownload(@RequestParam("fileCode") String fileCode,@RequestParam("module") String module) {

		System.out.println(fileCode);
		String filebytes = null;
		filebytes = bService.downloadServiceWithString(fileCode);
		return ResponseWithFCDwonload2.generateResponse("Success", HttpStatus.OK, "200", filebytes);

	}
	@PostMapping(value = "/dowloadbytes")
	public ResponseEntity<Object> ApiForDownload1(@RequestParam("fileCode") String fileCode,@RequestParam("module") String module) {

		System.out.println(fileCode);
		byte[] filebytes = null;
		filebytes = bService.downloadService(fileCode);
		return ResponseWithFCDwonload.generateResponse("Success", HttpStatus.OK, "200", filebytes);

	}
	@PostMapping(value = "/dowloadpurebytes")
	public ResponseEntity<Object> ApiForDownload3(@RequestParam("fileCode") String fileCode,@RequestParam("module") String module) {

		System.out.println(fileCode);
		byte[] filebytes = null;
		filebytes = bService.downloadServiceDecodedBytes(fileCode);
		return ResponseWithFCDwonload.generateResponse("Success", HttpStatus.OK, "200", filebytes);

	}

	@PostMapping(value = "/fileSearch")
	public ResponseEntity<Object> ApiForSearch(@RequestParam("appCode") String appCode,@RequestParam("module") String module) {

		System.out.println(appCode);

		List<FileSaveWithFileCode> list = bService.searchService(appCode);
		HashMap<String, String> hash = new HashMap<>();
		list.stream().forEach(c -> {

			hash.put(c.getFileCode(), c.getName());
		});

		if (hash.isEmpty()) {
			return ResponseForSearch.generateResponse("Success", HttpStatus.OK, "016", hash);
		} else {
			return ResponseForSearch.generateResponse("Success", HttpStatus.OK, "015", hash);
		}

	}

	
	@PostMapping(value = "/fileSearchbyFileCode")
	public ResponseEntity<Object> ApiForSearchwith(@RequestParam("appCode") String appCode,@RequestParam("fileCode") String fileCode,
			@RequestParam("module") String module) {

		System.out.println(appCode);

		List<FileSaveWithFileCode> list = bService.searchService(appCode);
		HashMap<String, String> hash = new HashMap<>();
		list.stream().forEach(c -> {

			hash.put(c.getFileCode(), c.getName());
		});

		if (hash.isEmpty()) {
			return ResponseForSearch.generateResponse("Success", HttpStatus.OK, "016", hash);
		} else {
			return ResponseForSearch.generateResponse("Success", HttpStatus.OK, "015", hash);
		}

	}
	
	
	@DeleteMapping(value = "/filedelbyFC")
	public ResponseEntity<Object> ApiFodelte(@RequestParam("appCode") String appCode,@RequestParam("fileCode") String fileCode,
			@RequestParam("module") String module ) {

		System.out.println(fileCode);

		int result = bService.deleteService(fileCode);

		System.out.println(result);

		if (result == 0) {
			return Response2.generateResponse("No file availble with this  App Code", HttpStatus.OK, "018");
		} else {

			return Response2.generateResponse("done", HttpStatus.OK, "017");
		}

	}

}
