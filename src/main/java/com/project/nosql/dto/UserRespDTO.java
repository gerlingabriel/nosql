package com.project.nosql.dto;

import java.io.Serializable;

public class UserRespDTO implements Serializable {

    private String nome;
    private String email;

    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }
    public String getEmail() {
            return email;
    }
    public void setEmail(String email) {
            this.email = email;
    }
    public UserRespDTO(String nome, String email) {
            this.nome = nome;
            this.email = email;
    }

}
