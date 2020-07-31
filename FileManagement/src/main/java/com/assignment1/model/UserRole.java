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
@Table(name = "user_role")
public class UserRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1534991208055504911L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "user_id")
    private long userId;

    @Column(name = "role_id")
    private long roleId;
 
}
