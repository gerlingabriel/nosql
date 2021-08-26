package com.project.nosql.dto.userDTO;

import java.io.Serializable;

public class UserDTO implements Serializable{

    private String id;
    private String name;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UserDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    
    
}
