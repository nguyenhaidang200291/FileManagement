package com.assignment1.service.test;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment1.model.AppUser;
import com.assignment1.repository.AppUserRepository;
import com.assignment1.repository.DBFileRepository;
import com.assignment1.service.AppUserService;
import com.assignment1.service.DBFileService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AppUserServiceTest {
	
    @Mock
    private DBFileService dbFileService;
    
    @Mock
    private AppUserService appUserService;
    
    @MockBean
    private DBFileRepository dbFileRepository;
    
    @MockBean
    private AppUserRepository appUserRepository;

    @Test
    public void findByUserNameTest() throws Exception 
    {
    	AppUser appUser = new AppUser(1L, "dangnh5","$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",1);
        when(appUserService.findByUserName("dangnh5")).thenReturn(appUser);
    }
}
