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
public class UserRoleDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3393219428029308791L;
	private long id;
	private long userId;
	private long roleId;
}
