package com.document.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.document.entity.DataTable1;

@Repository
public interface FileRepo extends JpaRepository<DataTable1,Integer> {

}
