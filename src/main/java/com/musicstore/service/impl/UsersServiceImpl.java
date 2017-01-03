package com.musicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.UsersDao;
import com.musicstore.model.Users;
import com.musicstore.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersDao usersDao;
    
    @Override
    public Users getUserByUsername(String username) {
	// TODO Auto-generated method stub
	return usersDao.getUserByUsername(username);
    }

    @Override
    public void updateUsers(Users user) {
	// TODO Auto-generated method stub
	usersDao.updateUsers(user);
    }

}
