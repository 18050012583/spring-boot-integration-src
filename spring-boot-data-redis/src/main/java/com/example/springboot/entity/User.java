package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * redis存储对象需要对象实现Serializable。
 */
@Data
public class User implements Serializable {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
