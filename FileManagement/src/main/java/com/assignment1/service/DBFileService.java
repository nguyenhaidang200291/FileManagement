package com.assignment1.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.assignment1.model.DBFile;
public interface DBFileService {	
	Page<DBFile> findAllFile(String userName, Pageable pageable);
	Optional<DBFile> getFileById(String id);
	DBFile saveDBFile(DBFile dbFile);
	void deleteFile (String id);
	DBFile storeFile(MultipartFile file);
	DBFile updateStoreFile(MultipartFile file, DBFile dbFile);
	DBFile getFile(String fileId);
}
