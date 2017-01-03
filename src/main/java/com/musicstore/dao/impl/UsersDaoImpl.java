package com.musicstore.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.dao.UsersDao;
import com.musicstore.model.Users;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Users getUserByUsername(String username) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	Query query = session.createQuery("from Users where username=?");
	query.setString(0, username);
	return (Users)query.uniqueResult();
    }

    @Override
    public void updateUsers(Users user) {
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(user);
	session.flush();
    }

}
