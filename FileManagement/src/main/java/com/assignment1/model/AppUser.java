package com.assignment1.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "app_user")
public class AppUser implements Serializable{
	private static final long serialVersionUID = 1009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    
    @Column(name = "user_name")
    private String userName;

    @Column(name = "encryted_password")
    private String encrytedPassword;

    @Column(name = "enabled")
    private int enabled;  
}
