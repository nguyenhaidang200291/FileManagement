package com.assignment1.dto.mapper;

import com.assignment1.dto.AppUserDTO;
import com.assignment1.model.AppUser;
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
public class AppUserMapperImpl implements AppUserMapper {

    @Override
    public AppUser toEntity(AppUserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setId( dto.getId() );
        appUser.setUserName( dto.getUserName() );
        appUser.setEncrytedPassword( dto.getEncrytedPassword() );
        appUser.setEnabled( dto.getEnabled() );

        return appUser;
    }

    @Override
    public AppUserDTO toDto(AppUser entity) {
        if ( entity == null ) {
            return null;
        }

        AppUserDTO appUserDTO = new AppUserDTO();

        appUserDTO.setId( entity.getId() );
        appUserDTO.setUserName( entity.getUserName() );
        appUserDTO.setEncrytedPassword( entity.getEncrytedPassword() );
        appUserDTO.setEnabled( entity.getEnabled() );

        return appUserDTO;
    }

    @Override
    public List<AppUser> toEntity(List<AppUserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AppUser> list = new ArrayList<AppUser>( dtoList.size() );
        for ( AppUserDTO appUserDTO : dtoList ) {
            list.add( toEntity( appUserDTO ) );
        }

        return list;
    }

    @Override
    public List<AppUserDTO> toDto(List<AppUser> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AppUserDTO> list = new ArrayList<AppUserDTO>( entityList.size() );
        for ( AppUser appUser : entityList ) {
            list.add( toDto( appUser ) );
        }

        return list;
    }
}
