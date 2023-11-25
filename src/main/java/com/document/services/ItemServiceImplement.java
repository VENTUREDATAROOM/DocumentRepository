package com.document.services;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.document.entity.DriverDetails;
import com.document.entity.FarmerInfo;
import com.document.entity.FarmerInfoEntity;
import com.document.entity.Items;
import com.document.entity.VegetableEntity;
import com.document.model.BasicDetailsDTO;
import com.document.repo.DeliveryPartnerRepo;
import com.document.repo.DriverDetailRepo;
import com.document.repo.FarmerInfoRepo;
import com.document.repo.ItemsRepo;
import com.document.repo.VegetableRepo;

;

@Service
public class ItemServiceImplement implements ItemService {

	@Autowired
	ModelMapper mapper;

	@Autowired
	ItemsRepo itemrepo;

	@Autowired
	DriverDetailRepo driverrepo;

	@Autowired
	VegetableRepo vegetablerepo;

	@Autowired
	DeliveryPartnerRepo deliveryrepo;

	@Autowired
	FarmerInfoRepo farmerrepo;

//
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ItemServiceImplement.class);

	@Override
	public VegetableEntity VegetableService(VegetableEntity vegetablentity) {

		return vegetablerepo.save(vegetablentity);
	}

	@Override
	public FarmerInfoEntity farmerService(FarmerInfoEntity farmerentity) {
		// TODO Auto-generated method stub
		return deliveryrepo.save(farmerentity);
	}

	@Override
	public List<BasicDetailsDTO> getallItems() {

		List<Items> itemss = itemrepo.findAll();
		List<BasicDetailsDTO> basicdtoo = null;
		try {

			basicdtoo = (List<BasicDetailsDTO>) mapper.map(itemss, BasicDetailsDTO.class);

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
		}
		return basicdtoo;

	}

	@Override
	public List<Items> getItemsById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FarmerInfoEntity> getallFarmardetail() {
		// TODO Auto-generated method stub
		return deliveryrepo.findAll();
	}

	@Override
	public List<FarmerInfoEntity> getFarmerdetailById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VegetableEntity> getallVegetableDetail() {
		// TODO Auto-generated method stub
		return vegetablerepo.findAll();
	}

	@Override
	public List<VegetableEntity> getVegetableDetailById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FarmerInfo farmerinfo(FarmerInfo farmerinformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverDetails driverdetailservice(DriverDetails driverdetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FarmerInfo> getallFarmerinfo() {
		return farmerrepo.findAll();
	}

	@Override
	public List<FarmerInfo> getFarmerinfoById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverDetails> getdriverdetailsinfo() {
		// TODO Auto-generated method stub
		return driverrepo.findAll();
	}

	@Override
	public List<DriverDetails> getdrivDetailsById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicDetailsDTO itemservice(BasicDetailsDTO basicDetailsDTO) {
		try {

			Items basicdetaildto = mapper.map(basicDetailsDTO, Items.class);
			itemrepo.save(basicdetaildto);

		} catch (Exception e) {
			log.error("there is an exception in  registring the user {} ", e.getMessage());
		}
		return basicDetailsDTO;
	}

	@Override
	public String saveVegeatableImage(@Valid MultipartFile pic, String userCode, String vegId) {
		// TODO Auto-generated method stub
		return null;
	}

}
