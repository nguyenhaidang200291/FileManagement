package com.assignment1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment1.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

	Page<DBFile> findByUserName(String userName, Pageable pageable);
	DBFile findByUserName(String userName);
	@Query(value = "SELECT * FROM files " +
	        "WHERE files.user_name = ?1 Or files.share_file = 1", nativeQuery = true)
	Page<DBFile> findAllFile(String userName, Pageable pageable);
}
