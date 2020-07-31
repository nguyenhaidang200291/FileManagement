package com.assignment1.dto.mapper;

import com.assignment1.dto.UserRoleDTO;
import com.assignment1.model.UserRole;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-31T13:25:01+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRole toEntity(UserRoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserRole userRole = new UserRole();

        userRole.setId( dto.getId() );
        userRole.setUserId( dto.getUserId() );
        userRole.setRoleId( dto.getRoleId() );

        return userRole;
    }

    @Override
    public UserRoleDTO toDto(UserRole entity) {
        if ( entity == null ) {
            return null;
        }

        UserRoleDTO userRoleDTO = new UserRoleDTO();

        userRoleDTO.setId( entity.getId() );
        userRoleDTO.setUserId( entity.getUserId() );
        userRoleDTO.setRoleId( entity.getRoleId() );

        return userRoleDTO;
    }

    @Override
    public List<UserRole> toEntity(List<UserRoleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<UserRole> list = new ArrayList<UserRole>( dtoList.size() );
        for ( UserRoleDTO userRoleDTO : dtoList ) {
            list.add( toEntity( userRoleDTO ) );
        }

        return list;
    }

    @Override
    public List<UserRoleDTO> toDto(List<UserRole> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserRoleDTO> list = new ArrayList<UserRoleDTO>( entityList.size() );
        for ( UserRole userRole : entityList ) {
            list.add( toDto( userRole ) );
        }

        return list;
    }
}
