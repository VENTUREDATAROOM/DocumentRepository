package com.document.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.document.entity.DriverDetails;

@Repository
public interface DriverDetailRepo extends JpaRepository<DriverDetails, Long> {

	DriverDetails findByuserCode(String userCode);

	DriverDetails findBydriverNumber(String driverNumber);

	DriverDetails findBydriverArea(String area);

	Long countByUserCode(String userCode);

}
