package com.document.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.document.entity.FileSaveWithFileCode;

public interface RepoWithFileCode  extends JpaRepository<FileSaveWithFileCode, Integer>{

	
	List<FileSaveWithFileCode> findByFileCode(String fileCode );
	List<FileSaveWithFileCode> findByAppCode(String appCode );

	@Modifying
	@Transactional
    @Query(value = "DELETE FROM FileSaveWithFileCode f where f.fileCode = ?1")
    int deletebyfileCodenative(String fileCode);
	
}
