package com.document.services;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.document.entity.DataTable1;
import com.document.entity.FileSaveWithFileCode;
import com.document.repo.FileRepo;
import com.document.repo.RepoWithFileCode;



@Service
public class BlobService {

	@Autowired
	FileRepo filerepo;

	@Autowired
	RepoWithFileCode repoWithFileCode;

	public String singlefile(String appCode, MultipartFile file, String scantionCode, ModelMap map) {

		try {
			DataTable1 d1 = new DataTable1(appCode, scantionCode, file.getOriginalFilename(), file.getBytes());
			filerepo.save(d1);

			return "D";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "E";
		}

	}

	// service to insert multiple files
	public String filearray(String appCode, MultipartFile[] dataSet, String scantionCode, ModelMap map) {

		try {
			// filerepo.save(new
			// DataTable1(appCode,file.getOriginalFilename(),file.getBytes()));
			for (int i = 0; i < dataSet.length; i++) {
				System.out.println(dataSet[i].getOriginalFilename());
				MultipartFile file = dataSet[i];
				DataTable1 d1 = new DataTable1(appCode, scantionCode, file.getOriginalFilename(), file.getBytes());
				filerepo.save(d1);
			}
			return "D";
		} catch (Exception e) {
			return "E";
		}

	}

	// save multiple with password protected too
	public String filearray(String appCode, MultipartFile dataSet, String scantionCode, ModelMap map) {
		try {

			// filerepo.save(new
			// DataTable1(appCode,file.getOriginalFilename(),file.getBytes()));

			System.out.println(dataSet.getOriginalFilename());
			DataTable1 d1 = new DataTable1(appCode, scantionCode, dataSet.getOriginalFilename(), dataSet.getBytes());
			filerepo.save(d1);

			return "D";
		} catch (Exception e) {
			return "E";
		}

	}

	// service to insert multiple files with fileCode
	public HashMap<String, String> insertWithFileCode(String appCode, HashMap<String, MultipartFile> hashData,
			String scantionCode) {
		Map<String, String> response = new HashMap<String, String>();

		for (Map.Entry<String, MultipartFile> newIterator : hashData.entrySet()) {
			try {
				repoWithFileCode.save(new FileSaveWithFileCode(newIterator.getKey(), appCode, scantionCode,
						newIterator.getValue().getOriginalFilename(),
						Base64.encodeBase64(newIterator.getValue().getBytes())));

				response.put(newIterator.getKey(), "D");
			} catch (Exception e) {
				response.put(newIterator.getKey(), "N");
			}

		}
		return (HashMap<String, String>) response;

	}

	// download wale ke lie service
	public byte[] downloadServiceWithFile(String fileCode) {
		String path = "E:\\test";
		List<FileSaveWithFileCode> f = repoWithFileCode.findByFileCode(fileCode);
		File nf = new File(path + File.separator + "001.pdf");
		byte[] b = Base64.decodeBase64(f.get(0).getFileInput());
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(nf);
			fileOutputStream.write(b);
			fileOutputStream.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return f.get(0).getFileInput();
	}

	// download wale ke lie service
	public byte[] downloadService(String fileCode) {
		List<FileSaveWithFileCode> f = null;
		try {
			f = repoWithFileCode.findByFileCode(fileCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f.get(0).getFileInput();
	}

//   download wale ke lie service 
	public String downloadServiceWithString(String fileCode) {
		List<FileSaveWithFileCode> f = null;
		String encoded = "";
		try {
			f = repoWithFileCode.findByFileCode(fileCode);
			byte[] b = Base64.decodeBase64(f.get(0).getFileInput());
			encoded = Base64.encodeBase64String(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encoded;
	}
	// download wale ke lie service
	public byte[] downloadServiceDecodedBytes(String fileCode) {
		List<FileSaveWithFileCode> f = null;
		byte[] respo =null;
		try {
			f = repoWithFileCode.findByFileCode(fileCode);
			respo = Base64.decodeBase64(f.get(0).getFileInput());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respo;
	}

	// download wale ke lie service
	public byte[] downloadService1(String fileCode) {

		List<FileSaveWithFileCode> f = repoWithFileCode.findByFileCode(fileCode);
		byte[] respo = Base64.decodeBase64(f.get(0).getFileInput());
		return respo;
	}

	public List<FileSaveWithFileCode> searchService(String appCode) {

		List<FileSaveWithFileCode> listOfAvialableFile = repoWithFileCode.findByAppCode(appCode);

		return listOfAvialableFile;
	}

	public int deleteService(String fileCode) {

		int result = repoWithFileCode.deletebyfileCodenative(fileCode);

		return result;
	}
	
	public String  DocumentNumber(String module,String key) {
		String doc="";
		LocalDate today = LocalDate.now();
		today.getYear();
		System.out.println(today.getYear());
		doc=module.substring(0, 2)+key+today.getYear()+today.getDayOfMonth()+today.getMonthValue()+"0001";

		System.out.println(doc);

		return doc;
	}
	

}
