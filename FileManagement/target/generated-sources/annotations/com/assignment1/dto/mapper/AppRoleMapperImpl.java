package com.assignment1.dto.mapper;

import com.assignment1.dto.AppRoleDTO;
import com.assignment1.model.AppRole;
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
public class AppRoleMapperImpl implements AppRoleMapper {

    @Override
    public AppRole toEntity(AppRoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AppRole appRole = new AppRole();

        appRole.setId( dto.getId() );
        appRole.setRoleName( dto.getRoleName() );

        return appRole;
    }

    @Override
    public AppRoleDTO toDto(AppRole entity) {
        if ( entity == null ) {
            return null;
        }

        AppRoleDTO appRoleDTO = new AppRoleDTO();

        appRoleDTO.setId( entity.getId() );
        appRoleDTO.setRoleName( entity.getRoleName() );

        return appRoleDTO;
    }

    @Override
    public List<AppRole> toEntity(List<AppRoleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AppRole> list = new ArrayList<AppRole>( dtoList.size() );
        for ( AppRoleDTO appRoleDTO : dtoList ) {
            list.add( toEntity( appRoleDTO ) );
        }

        return list;
    }

    @Override
    public List<AppRoleDTO> toDto(List<AppRole> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AppRoleDTO> list = new ArrayList<AppRoleDTO>( entityList.size() );
        for ( AppRole appRole : entityList ) {
            list.add( toDto( appRole ) );
        }

        return list;
    }
}
