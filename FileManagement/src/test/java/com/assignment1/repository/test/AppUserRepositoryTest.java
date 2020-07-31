package com.assignment1.repository.test;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment1.model.AppUser;
import com.assignment1.repository.AppUserRepository;
import com.assignment1.repository.DBFileRepository;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class AppUserRepositoryTest {
	
  
    @MockBean
    private DBFileRepository dbFileRepository;
    
    @MockBean
    private AppUserRepository appUserRepository;

    @Test
    public void findByIdTest() {
    	AppUser appUser = new AppUser(1L, "dangnh5","$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",1);
        when(appUserRepository.findById(1L)).thenReturn(Optional.of(appUser));
    	
    }
    
    @Test
    public void findByUserNameTest() {
    	AppUser appUser = new AppUser(1L, "dangnh5","$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu",1);
        when(appUserRepository.findByUserName("dangnh5")).thenReturn(appUser);	
    }
}
