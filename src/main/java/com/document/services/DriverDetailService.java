package com.document.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.document.entity.DriverDetails;
import com.document.model.DriverDetailDTO;
import com.document.repo.DriverDetailRepo;

@Service
public class DriverDetailService {

	@Autowired
	DriverDetailRepo driverdetailrepo;

	@Autowired
	ModelMapper mapper;

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DriverDetailService.class);

	DriverDetailDTO driverdetaildto = null;

	public DriverDetailDTO findByuserCode(String userCode) {

		try {
			DriverDetails driverdetails = driverdetailrepo.findByuserCode(userCode);
			driverdetaildto = mapper.map(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return driverdetaildto;
		}

	}

	public DriverDetailDTO findByDriverbydriverNumber(String driverNumber) {

		try {
			DriverDetails driverdetails = driverdetailrepo.findBydriverNumber(driverNumber);
			driverdetaildto = mapper.map(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return driverdetaildto;
		}
	}

	public DriverDetailDTO findByDriverbydriverarea(String area) {
		try {
			DriverDetails driverdetails = driverdetailrepo.findBydriverArea(area);
			driverdetaildto = mapper.map(driverdetails, DriverDetailDTO.class);
			return driverdetaildto;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by ID {} ", e.getMessage());
			return driverdetaildto;
		}

	}

	public Long findVegetableCount(String userCode) {
		Long count = 0L;
		try {
			count = driverdetailrepo.countByUserCode(userCode);
			return count;
		} catch (Exception e) {
			log.error("there is an exception in  fetching the  image of the vegetable by vegName {} ", e.getMessage());
			return count;
		}
	}
}