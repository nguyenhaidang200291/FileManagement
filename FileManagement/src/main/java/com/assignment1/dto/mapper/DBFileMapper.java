package com.assignment1.dto.mapper;

import org.mapstruct.*;

import com.assignment1.dto.DBFileDTO;
import com.assignment1.model.DBFile;

/**
 * Mapper for the entity Customer and its DTO CustomerDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DBFileMapper extends EntityMapper<DBFileDTO, DBFile> {

    default DBFile fromId(String id) {
        if (id == null) {
            return null;
        }
        DBFile dbFile = new DBFile();
        dbFile.setId(id);
        return dbFile;
    }
}