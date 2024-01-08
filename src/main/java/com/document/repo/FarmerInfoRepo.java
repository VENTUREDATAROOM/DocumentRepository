package com.document.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.document.entity.FarmerInfo;

public interface FarmerInfoRepo extends JpaRepository<FarmerInfo, Integer> {

	FarmerInfo findByPhoneNumber(String phoneNumber);

	FarmerInfo findByFarmerId(int farmerId);

	FarmerInfo findByFarmerName(String farmerName);

	Long countByUserCode(String userCode);

}
