package com.project.nosql.exception;

import java.io.Serializable;

public class StantanderError implements Serializable{

    private Long timestamp;
    private String error;
    private String messager;
    private String path;
    
    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMessager() {
        return messager;
    }
    public void setMessager(String messager) {
        this.messager = messager;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public StantanderError(Long timestamp, String error, String messager, String path) {
        this.timestamp = timestamp;
        this.error = error;
        this.messager = messager;
        this.path = path;
    }    
}
