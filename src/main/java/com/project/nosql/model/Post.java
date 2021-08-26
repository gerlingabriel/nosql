package com.project.nosql.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.nosql.dto.Comments.CommetsDTO;
import com.project.nosql.dto.userDTO.UserDTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post implements Serializable{

    @Id
    private String id;

    private Date date;
    private String title;
    private String boby;
    private UserDTO user;
    private List<CommetsDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String boby, UserDTO user) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.boby = boby;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return comments;
    }

    public void setComments(List<CommetsDTO> comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    

    
}
