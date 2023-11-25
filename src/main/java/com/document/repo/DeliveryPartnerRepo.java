package com.document.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.document.entity.FarmerInfoEntity;

public interface DeliveryPartnerRepo extends JpaRepository<FarmerInfoEntity, Integer> {

}
