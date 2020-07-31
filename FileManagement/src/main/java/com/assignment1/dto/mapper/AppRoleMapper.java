package com.assignment1.dto.mapper;

import org.mapstruct.*;

import com.assignment1.dto.AppRoleDTO;
import com.assignment1.model.AppRole;


/**
 * Mapper for the entity Customer and its DTO CustomerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AppRoleMapper extends EntityMapper<AppRoleDTO, AppRole> {

    default AppRole fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppRole appRole = new AppRole();
        appRole.setId(id);
        return appRole;
    }
}