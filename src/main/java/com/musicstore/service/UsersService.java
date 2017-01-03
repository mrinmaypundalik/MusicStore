package com.musicstore.service;

import com.musicstore.model.Users;

public interface UsersService {

    Users getUserByUsername(String username);
    
    void updateUsers(Users user);
}
