package com.assignment1.controller.test;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment1.model.DBFile;
import com.assignment1.repository.AppUserRepository;
import com.assignment1.repository.DBFileRepository;
import com.assignment1.service.AppUserService;
import com.assignment1.service.DBFileService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class FileControllerTest {
	
    @Mock
    private DBFileService dbFileService;
    
    @Mock
    private AppUserService appUserService;
    
    @MockBean
    private DBFileRepository dbFileRepository;
    
    @MockBean
    private AppUserRepository appUserRepository;

    @Before
    public void init() {
        List<DBFile> dbFile = Arrays.asList(
                new DBFile("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7", "dangnh5", null, null, null, null, 0, 0, null, null, null, null),
                new DBFile("65310512-aa4e-460d-a876-f3c21d565f26", "dangnh5", null, null, null, null, 0, 0, null, null, null, null),
                new DBFile("a05c4662-79ce-4876-8335-94959ae50bfd", "dbuser1", null, null, null, null, 0, 0, null, null, null, null));

        when(dbFileRepository.findAll()).thenReturn(dbFile);
      	
    }
    
    @Test
    public void getFileByIdTest() throws Exception 
    {
		DBFile dbFile = new DBFile("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7", "dangnh5", null, null, null, null, 0, 0,
				null, null, null, null);

		when(dbFileService.getFileById("2e61f6ed-bf84-41cf-bcb1-a5275b8649d7")).thenReturn(Optional.of(dbFile));
    }
//    @Test
//    public void findAllFileOfUserTest() throws Exception {
//
//        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYW5nbmg1IiwiZXhwIjoxNTk1OTQzNzU3LCJpYXQiOjE1OTU5MjU3NTd9.6bnG3Q93aYPdfpsvKLnGVfLEoxIEBvzS0fA4VVxf3Yj3kK0qPO7fJhGefKRGmMPYs54si0AAPfN8gpc_SSpteg";
//        mockMvc.perform(
//
//                MockMvcRequestBuilders.get("/api/findallfiles")
//                .header("Authorization", "Bearer " + token))
////                .header("Authorization", token))
////                .andExpect(status().isOk())
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
////                .andExpect(jsonPath("$.id", is("a05c4662-79ce-4876-8335-94959ae50bfd")))
////                .andExpect(jsonPath("$.userName", is("dbuser1")))
////                .andExpect(jsonPath("$.data", is(null)))
////                .andExpect(jsonPath("$.fileName", is(null)))
////                .andExpect(jsonPath("$.fileType", is(null)))
////                .andExpect(jsonPath("$.uriDownload", is(null)))
////                .andExpect(jsonPath("$.size", is(0)))
////                .andExpect(jsonPath("$.shareFile", is(0)))
////                .andExpect(jsonPath("$.createDate", is(null)))
////                .andExpect(jsonPath("$.updateDate", is(null)))
////                .andExpect(jsonPath("$.createUser", is(null)))
////                .andExpect(jsonPath("$.updateUser", is(null)))
//                .andExpect(status().isUnauthorized())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//        		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
//        		.andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("dangnh5"))
//        		.andExpect(MockMvcResultMatchers.jsonPath("$.encrytedPassword").value("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu"))
//        		.andExpect(MockMvcResultMatchers.jsonPath("$.enabled").value(1))        		
//                
//                .andDo(print());
////                .andReturn();
//        verify(appUserRepository, times(1)).findById(1L);
////        System.out.println(mvcResult.getResponse().getContentAsString());
//    }
    

}
