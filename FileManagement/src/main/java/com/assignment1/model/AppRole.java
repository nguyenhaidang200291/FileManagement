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
@Table(name = "app_role")
public class AppRole implements Serializable {
	private static final long serialVersionUID = 3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private long id;
    
    @Column(name = "role_name")
    private String roleName;

}
