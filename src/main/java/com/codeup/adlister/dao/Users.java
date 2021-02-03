package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    String hashPassword(String password);
    void changeEmail(String email, String user);
    void changePassword(String password, String user);
}
