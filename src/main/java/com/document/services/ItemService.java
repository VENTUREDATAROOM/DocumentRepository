package com.document.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.document.entity.DriverDetails;
import com.document.entity.FarmerInfo;
import com.document.entity.FarmerInfoEntity;
import com.document.entity.Items;
import com.document.entity.VegetableEntity;
import com.document.model.BasicDetailsDTO;

@Service
public interface ItemService {

//	public Items itemservice(Items items);

	public BasicDetailsDTO itemservice(BasicDetailsDTO basicDetailsDTO);

	public FarmerInfoEntity farmerService(FarmerInfoEntity farmerentity);

	public VegetableEntity VegetableService(VegetableEntity vegetableEntity);

	public FarmerInfo farmerinfo(FarmerInfo farmerinformation);

	public DriverDetails driverdetailservice(DriverDetails driverdetails);

	public List<DriverDetails> getdriverdetailsinfo();

	public List<FarmerInfo> getallFarmerinfo();

//	public List<Items> getallItems();

	public List<BasicDetailsDTO> getallItems();

	public List<FarmerInfoEntity> getallFarmardetail();

	public List<VegetableEntity> getallVegetableDetail();

	public List<Items> getItemsById();

	public List<FarmerInfoEntity> getFarmerdetailById();

	public List<VegetableEntity> getVegetableDetailById();

	public List<FarmerInfo> getFarmerinfoById();

	public List<DriverDetails> getdrivDetailsById();

	public String saveVegeatableImage(@Valid MultipartFile pic, String userCode, String vegId);
}
