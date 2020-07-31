package com.assignment1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assignment1.config.SecurityUtils;
import com.assignment1.dto.DBFileDTO;
import com.assignment1.dto.mapper.DBFileMapper;
import com.assignment1.model.DBFile;
import com.assignment1.service.DBFileService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FileController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(FileController.class);

	@Autowired
	private DBFileService dbFileService;

	@Autowired
	private DBFileMapper dbFileMapper;

	// Get a list of all the files
	@GetMapping("/findallfiles")
	public ResponseEntity<Map<String, Object>> findAllFileOfUser(Pageable pageable) {
		try {
			// Get username login
			String userName = SecurityUtils.getCurrentUserIDLogin().get().toString();
			// List out the files of userName, proceed to paging
			Page<DBFile> listDBFile = dbFileService.findAllFile(userName, pageable);
			Page<DBFileDTO> result = listDBFile.map(dbFileMapper::toDto);

			List<DBFileDTO> list = new ArrayList<DBFileDTO>();
			list = result.getContent();
			if (result.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				Map<String, Object> response = new HashMap<>();
				response.put("listDBFile", list);
				response.put("currentPage", result.getNumber());
				response.put("totalItems", result.getTotalElements());
				response.put("totalPages", result.getTotalPages());
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Retrieve file information by id passed
	@GetMapping("/files/{id}")
	public ResponseEntity<DBFileDTO> getFileById(@PathVariable("id") String id) {
		Optional<DBFile> optionalDBFile = dbFileService.getFileById(id);

		if (optionalDBFile.isPresent()) {
			DBFileDTO dbFileDTO = dbFileMapper.toDto(optionalDBFile.get());
			return new ResponseEntity<>(dbFileDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Delete 1 file by id passed
	@DeleteMapping("/files/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") String id) {
		try {
			dbFileService.deleteFile(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	// File sharing
	@PutMapping("/share_file/{id}")
	public ResponseEntity<DBFileDTO> updateShareFile(@PathVariable("id") String id, @RequestBody DBFileDTO dbFileDTO) {
		Optional<DBFile> dbFileData = dbFileService.getFileById(id);
		if (dbFileData.isPresent()) {
			DBFile dbFile = dbFileData.get();
			dbFile.setShareFile(dbFileDTO.getShareFile());
			dbFile = dbFileService.saveDBFile(dbFile);
			return new ResponseEntity<>(dbFileMapper.toDto(dbFile), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Edit File according to id passed
	@PutMapping("/edit_file/{id}")
	public ResponseEntity<DBFileDTO> editFile(@PathVariable("id") String id, @RequestParam("file") MultipartFile file) {
		Optional<DBFile> dbFileData = dbFileService.getFileById(id);
		if (dbFileData.isPresent()) {
			DBFile dbFile = dbFileService.updateStoreFile(file, dbFileData.get());
			return new ResponseEntity<>(dbFileMapper.toDto(dbFile), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Upload file
	@PostMapping("/uploadFile")
	public DBFileDTO uploadFile(@RequestParam("file") MultipartFile file) {
		DBFile dbFile = dbFileService.storeFile(file);
		DBFileDTO result = dbFileMapper.toDto(dbFile);
		return result;
	}

	// Upload Multiple Files
	@PostMapping("/uploadMultipleFiles")
	public List<DBFileDTO> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}

	// Download File
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
		// Load file from database
		DBFile dbFile = dbFileService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
				.body(new ByteArrayResource(dbFile.getData()));
	}

}
