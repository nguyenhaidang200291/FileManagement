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
public class AppRoleDTO implements Serializable{
	private static final long serialVersionUID = 2009157732242241606L;
	private long id;
	private String roleName;
}
