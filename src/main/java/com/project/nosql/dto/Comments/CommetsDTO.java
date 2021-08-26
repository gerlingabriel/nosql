package com.project.nosql.dto.Comments;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.nosql.dto.userDTO.UserDTO;

public class CommetsDTO implements Serializable{

    private String text;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;
    private UserDTO user;
    
    public CommetsDTO() {
    }

    public CommetsDTO(String text, Date data, UserDTO user) {
        this.text = text;
        this.data = data;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    
    
}
