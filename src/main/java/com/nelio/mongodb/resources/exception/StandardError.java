package com.nelio.mongodb.resources.exception;

public class StandardError {

    private Long timestamp;
    private Integer status;
    private String mensager;
    private String error;
    private String path;

    public StandardError() {
    }

    public StandardError(Long timestamp, Integer status, String mensager, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.mensager = mensager;
        this.error = error;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensager() {
        return mensager;
    }

    public void setMensager(String mensager) {
        this.mensager = mensager;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}