package com.bootcamp.dao.impl;

import com.bootcamp.dao.UserDAO;
import com.bootcamp.datasource.MockedDB;
import com.bootcamp.entities.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public User getUserById(String idUser) {
		return MockedDB.findUserbyId(idUser);
	}

	@Override
	public boolean updateUser(User user) {
		for (User u : MockedDB.findAllUsers()) {
			if (u.getIdUser().equals(user.getIdUser())) {
				u = user;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addUser(User user) {
		return MockedDB.findAllUsers().add(user);
	}

	@Override
	public boolean deleteUser(String idUser) {
		User user = MockedDB.findUserbyId(idUser);
		return MockedDB.findAllUsers().remove(user);
	}

}
