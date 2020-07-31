package com.assignment1.repository.test;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment1.model.DBFile;
import com.assignment1.repository.AppUserRepository;
import com.assignment1.repository.DBFileRepository;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DBFileRepositoryTest {
	
    @MockBean
    private DBFileRepository dbFileRepository;
    
    @MockBean
    private AppUserRepository appUserRepository;

    @Test
    public void findByUserNameTest() {
      List<DBFile> dbFile = Arrays.asList(
      new DBFile("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7", "dangnh5", null, null, null, null, 0, 0, null, null, null, null),
      new DBFile("65310512-aa4e-460d-a876-f3c21d565f26", "dangnh5", null, null, null, null, 0, 0, null, null, null, null),
      new DBFile("a05c4662-79ce-4876-8335-94959ae50bfd", "dbuser1", null, null, null, null, 0, 0, null, null, null, null));
    	

      // Pageable for Limit
      Pageable pageable = PageRequest.of(0, 1);
      
      Page<DBFile> pages = new PageImpl<DBFile>(dbFile, pageable, dbFile.size());

      when(dbFileRepository.findByUserName("dbuser1", pageable)).thenReturn(pages);  	
    }
   
    @Test
    public void findAllFileTest() {
      List<DBFile> dbFile = Arrays.asList(
      new DBFile("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7", "dangnh5", null, null, null, null, 0, 0, null, null, null, null),
      new DBFile("65310512-aa4e-460d-a876-f3c21d565f26", "dangnh5", null, null, null, null, 0, 0, null, null, null, null),
      new DBFile("a05c4662-79ce-4876-8335-94959ae50bfd", "dbuser1", null, null, null, null, 0, 0, null, null, null, null));
    	

      // Pageable for Limit
      Pageable pageable = PageRequest.of(0, 1);
      
      Page<DBFile> pages = new PageImpl<DBFile>(dbFile, pageable, dbFile.size());

      when(dbFileRepository.findAllFile("dangnh5", pageable)).thenReturn(pages);  	
    }
}
