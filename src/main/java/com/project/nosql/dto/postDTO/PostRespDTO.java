package com.project.nosql.dto.postDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.nosql.dto.Comments.CommetsDTO;
import com.project.nosql.dto.userDTO.UserDTO;

public class PostRespDTO implements Serializable{

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private String title;
    private String boby;
    private UserDTO user;
    private List<CommetsDTO> Comments = new ArrayList<>();
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBoby() {
        return boby;
    }
    public void setBoby(String boby) {
        this.boby = boby;
    }
    public UserDTO getUser() {
        return user;
    }
    public void setUser(UserDTO user) {
        this.user = user;
    }
    public List<CommetsDTO> getComments() {
        return Comments;
    }
    public void setComments(List<CommetsDTO> comments) {
        Comments = comments;
    }
    public PostRespDTO(Date date, String title, String boby, UserDTO user, List<CommetsDTO> comments) {
        this.date = date;
        this.title = title;
        this.boby = boby;
        this.user = user;
        Comments = comments;
    }
    

    
}
