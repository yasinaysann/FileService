package com.yasin.fileservice.dto;


import java.util.Date;

public class ResponseFile {
    private String url;
    private String filename;
    private Long filesize;
    private String type;

    private Date lastModifiedDate;

    public ResponseFile(String url, String filename, Long filesize, String type, Date lastModifiedDate) {
        this.url = url;
        this.filename = filename;
        this.filesize = filesize;
        this.type = type;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
