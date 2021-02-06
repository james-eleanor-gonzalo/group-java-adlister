package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    List<User> all();
    User find(String column, String value);
    User findByUsername(String username);
    Long insert(User user);
    String hashPassword(String password);
    void changeEmail(String email, String user);
    void changePassword(String password, String user);
}
