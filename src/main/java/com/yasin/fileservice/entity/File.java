package com.yasin.fileservice.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;

@Document(collection = "FilesService")
public class File {
    @Id
    private String id;
    private String filename;
    private Long filesize;

    private String type;
    private byte[] file;

    @CreatedDate
    private Date createAt;
    @LastModifiedDate
    private Date lastModifiedDate;

    public File() {
    }

//    public File(String filename, Long filesize, String type, byte[] file, Date createAt, Date lastModifiedDate) {
//        this.filename = filename;
//        this.filesize = filesize;
//        this.type = type;
//        this.file = file;
//        this.createAt = createAt;
//        this.lastModifiedDate = lastModifiedDate;
//    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filesize='" + filesize + '\'' +
                ", file=" + Arrays.toString(file) +
                ", creatAt=" + createAt +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
