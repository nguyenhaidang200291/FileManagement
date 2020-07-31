package com.assignment1.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DBFileDTO {
	
    private String id;
    private String userName;
    private String fileName;
    private String fileType;
    private byte[] data;
    private String uriDownload;
    private long size;
    private long shareFile;
    private Date createDate;
    private Date updateDate;
    private String createUser;
    private String updateUser;
}
