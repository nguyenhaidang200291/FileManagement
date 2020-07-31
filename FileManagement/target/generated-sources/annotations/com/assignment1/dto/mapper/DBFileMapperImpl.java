package com.assignment1.dto.mapper;

import com.assignment1.dto.DBFileDTO;
import com.assignment1.model.DBFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-31T13:25:00+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class DBFileMapperImpl implements DBFileMapper {

    @Override
    public DBFile toEntity(DBFileDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DBFile dBFile = new DBFile();

        dBFile.setId( dto.getId() );
        dBFile.setUserName( dto.getUserName() );
        byte[] data = dto.getData();
        if ( data != null ) {
            dBFile.setData( Arrays.copyOf( data, data.length ) );
        }
        dBFile.setFileName( dto.getFileName() );
        dBFile.setFileType( dto.getFileType() );
        dBFile.setUriDownload( dto.getUriDownload() );
        dBFile.setSize( dto.getSize() );
        dBFile.setShareFile( dto.getShareFile() );
        dBFile.setCreateDate( dto.getCreateDate() );
        dBFile.setUpdateDate( dto.getUpdateDate() );
        dBFile.setCreateUser( dto.getCreateUser() );
        dBFile.setUpdateUser( dto.getUpdateUser() );

        return dBFile;
    }

    @Override
    public DBFileDTO toDto(DBFile entity) {
        if ( entity == null ) {
            return null;
        }

        DBFileDTO dBFileDTO = new DBFileDTO();

        dBFileDTO.setId( entity.getId() );
        dBFileDTO.setUserName( entity.getUserName() );
        dBFileDTO.setFileName( entity.getFileName() );
        dBFileDTO.setFileType( entity.getFileType() );
        byte[] data = entity.getData();
        if ( data != null ) {
            dBFileDTO.setData( Arrays.copyOf( data, data.length ) );
        }
        dBFileDTO.setUriDownload( entity.getUriDownload() );
        dBFileDTO.setSize( entity.getSize() );
        dBFileDTO.setShareFile( entity.getShareFile() );
        dBFileDTO.setCreateDate( entity.getCreateDate() );
        dBFileDTO.setUpdateDate( entity.getUpdateDate() );
        dBFileDTO.setCreateUser( entity.getCreateUser() );
        dBFileDTO.setUpdateUser( entity.getUpdateUser() );

        return dBFileDTO;
    }

    @Override
    public List<DBFile> toEntity(List<DBFileDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DBFile> list = new ArrayList<DBFile>( dtoList.size() );
        for ( DBFileDTO dBFileDTO : dtoList ) {
            list.add( toEntity( dBFileDTO ) );
        }

        return list;
    }

    @Override
    public List<DBFileDTO> toDto(List<DBFile> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DBFileDTO> list = new ArrayList<DBFileDTO>( entityList.size() );
        for ( DBFile dBFile : entityList ) {
            list.add( toDto( dBFile ) );
        }

        return list;
    }
}
