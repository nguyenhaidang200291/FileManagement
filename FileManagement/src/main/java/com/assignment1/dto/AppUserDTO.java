package com.assignment1.dto;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4089853797808324626L;
	private long id;
	private String userName;
	private String encrytedPassword;
	private int enabled;
	private String password;
}
