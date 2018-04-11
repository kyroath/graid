package com.graid;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;

    public User(String username, String password) {

        this.username = username;
        this.password = password;

        // handle from database with id

    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(User another) {
        return username.equals(another.getUsername()) && password.equals(another.getPassword());
    }
}
