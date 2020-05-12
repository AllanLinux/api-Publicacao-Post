package com.allan.apiPublicacaoPost.dto;

import com.allan.apiPublicacaoPost.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    /**
     * Permite que os objetos possam ser convertidos em byte para que possam ser trafegados em rede
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
    // Getters e Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
