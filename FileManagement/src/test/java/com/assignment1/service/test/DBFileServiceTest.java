package com.assignment1.service.test;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment1.model.DBFile;
import com.assignment1.repository.AppUserRepository;
import com.assignment1.repository.DBFileRepository;
import com.assignment1.service.DBFileService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DBFileServiceTest {

	@Mock
	private DBFileService dbFileService;

	@MockBean
	private DBFileRepository dbFileRepository;

	@MockBean
	private AppUserRepository appUserRepository;

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	

	@Test
	public void storeFileTest() throws Exception {
		MockMultipartFile file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE,
				"Hello, World!".getBytes());
		DBFile dbFile = new DBFile();
		when(dbFileService.storeFile(file)).thenReturn(dbFile);
	}


	@Test
	public void getFileByIdTest() throws Exception {
		DBFile dbFile = new DBFile("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7", "dangnh5", null, null, null, null, 0, 0,
				null, null, null, null);

		when(dbFileService.getFileById("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7")).thenReturn(Optional.of(dbFile));
	}

	@Test
	public void saveDBFileTest() throws Exception {
		DBFile dbFile = new DBFile("a05c4662-79ce-4876-8335-94959ae50bfd", "dbuser1", null, null, null, null, 0, 0,
				null, null, null, null);
		DBFile dbFileSave = new DBFile();
		when(dbFileService.saveDBFile(dbFile)).thenReturn(dbFileSave);
	}

	@Test
	public void deleteFileTest() throws Exception {
		DBFile dbFile = new DBFile("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7", "dangnh5", null, null, null, null, 0, 0,
				null, null, null, null);

		Mockito.when(dbFileRepository.findById("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7")).thenReturn(Optional.of(dbFile));

		// when
		dbFileService.deleteFile("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7");

		// then
		Mockito.when(dbFileRepository.findById("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7")).thenReturn(Optional.of(dbFile))
				.thenReturn(null);
	}

	@Test
	public void getFileTest() throws Exception {
		DBFile dbFile = new DBFile("a05c4662-79ce-4876-8335-94959ae50bfd", "dbuser1", null, null, null, null, 0, 0,
				null, null, null, null);

		Mockito.when(dbFileService.getFile("a05c4662-79ce-4876-8335-94959ae50bfd")).thenReturn(dbFile);
	}
}
