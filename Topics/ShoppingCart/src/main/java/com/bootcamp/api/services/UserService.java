package com.bootcamp.api.services;

import java.util.List;

import com.bootcamp.api.entities.User;

public interface UserService {
	public User getByIdUser(Integer idUser);

	public User getByUsername(String username);

	public List<User> getAll();

	public User add(User user);

	public void remove(User user);

	public User update(User user);

	public User validate(String username, String password) throws Exception;
	
	public boolean exists(User user);

	boolean isUsernameAvailable(String username);

}
