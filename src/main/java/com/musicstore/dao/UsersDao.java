package com.musicstore.dao;

import com.musicstore.model.Users;

public interface UsersDao {
    Users getUserByUsername(String username);

    void updateUsers(Users user);
}
