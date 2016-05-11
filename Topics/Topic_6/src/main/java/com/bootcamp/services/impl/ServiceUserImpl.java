package com.bootcamp.services.impl;

import org.springframework.stereotype.Service;

import com.bootcamp.dao.UserDAO;
import com.bootcamp.dao.impl.UserDAOImpl;
import com.bootcamp.entities.User;
import com.bootcamp.services.ServiceUser;

@Service
public class ServiceUserImpl implements ServiceUser {
	private UserDAO userDAO;
	
	public ServiceUserImpl(){
		userDAO = new UserDAOImpl();
	}
	@Override
	public User getUserById(String idUser) {
		return userDAO.getUserById(idUser);
	}

	@Override
	public boolean updateUser(User userUpdate) {
		return userDAO.updateUser(userUpdate);
	}

	@Override
	public boolean deleteUser(String idUser) {
		return userDAO.deleteUser(idUser);
	}

	@Override
	public boolean addNewUser(User user) {
		return userDAO.addUser(user);
	}

}
