package com.assignment1.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assignment1.config.SecurityUtils;
import com.assignment1.exception.FileStorageException;
import com.assignment1.exception.MyFileNotFoundException;
import com.assignment1.model.DBFile;
import com.assignment1.repository.DBFileRepository;
import com.assignment1.service.DBFileService;

@Service
@Transactional
public class DBFileImpl implements DBFileService {
	
	@Autowired
	DBFileRepository dbFileRepository;

	@Override
	public DBFile storeFile(MultipartFile file) {
	       // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
			//trước tiên phải lây được username đăng nhâp
			String userName = SecurityUtils.getCurrentUserIDLogin().get().toString();
			//tìm kiếm userId của userName trong bảng app_user
			//Long userId = appUserService.findByUserName(userName).getId();
            DBFile dbFile = new DBFile();
            dbFile.setUserName(userName);
            dbFile.setFileName(fileName);
            dbFile.setFileType(file.getContentType());
            dbFile.setData(file.getBytes());
            dbFile.setSize(file.getSize());
            dbFile.setShareFile(0);
            Date date = new Date();
            dbFile.setCreateDate(date);
            dbFile.setUpdateDate(date);
            dbFile.setCreateUser(userName);
            dbFile.setUpdateUser(userName);
            DBFile objectDBFile = dbFileRepository.save(dbFile);
            //Cập nhật trường uri_download
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(objectDBFile.getId())
                    .toUriString();
            objectDBFile.setUriDownload(fileDownloadUri);
            return dbFileRepository.save(objectDBFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}

	@Override
	public DBFile updateStoreFile(MultipartFile file, DBFile dbFileData) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
			//trước tiên phải lây được username đăng nhâp
			String userName = SecurityUtils.getCurrentUserIDLogin().get().toString();
			dbFileData.setFileName(fileName);
			dbFileData.setFileType(file.getContentType());
			dbFileData.setData(file.getBytes());
			dbFileData.setSize(file.getSize());
            Date date = new Date();
            dbFileData.setUpdateDate(date);
            dbFileData.setUpdateUser(userName);
            DBFile objectDBFile = dbFileRepository.save(dbFileData);
            return dbFileRepository.save(objectDBFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}

	
	@Override
	public DBFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	}
	
	@Override
	public Page<DBFile> findAllFile(String userName, Pageable pageable) {
		return dbFileRepository.findAllFile(userName, pageable);
	}

	@Override
	public Optional<DBFile> getFileById(String id) {
		return dbFileRepository.findById(id);
	}

	@Override
	public void deleteFile(String id) {
		dbFileRepository.deleteById(id);
	}

	@Override
	public DBFile saveDBFile(DBFile dbFile) {
		return dbFileRepository.save(dbFile);
	}
}
