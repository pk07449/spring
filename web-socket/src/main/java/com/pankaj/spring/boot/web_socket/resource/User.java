package com.pankaj.spring.boot.web_socket.resource;

public class User {
    String name;
    Integer id;

    public User(String name, Integer id) {

        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
