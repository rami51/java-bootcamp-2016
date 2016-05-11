package com.bootcamp.dao;

import com.bootcamp.entities.User;

public interface UserDAO {
	public User getUserById(String idUser);
	public boolean updateUser(User user);
	public boolean addUser(User user);
	public boolean deleteUser(String idUser);
}
