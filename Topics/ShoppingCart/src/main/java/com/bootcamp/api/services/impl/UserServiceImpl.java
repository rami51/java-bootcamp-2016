package com.bootcamp.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.api.entities.User;
import com.bootcamp.api.repositories.UserRepository;
import com.bootcamp.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	/*
	 * public UserServiceImpl() { this.userDAO = new UserDAOImpl(); }
	 */

	@Override
	public User getByIdUser(Integer idUser) {
		return userRepository.findOne(idUser);
	}

	@Override
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User add(User user) {
		return userRepository.save(user);
	}

	@Override
	public void remove(User user) {
		userRepository.delete(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public User validate(String username, String password) throws Exception {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			} else
				throw new Exception("The password is incorrect.");
		} else
			throw new Exception("The username is incorrect.");
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		User user = userRepository.findByUsername(username);
		return user == null;
	}

	@Override
	public boolean exists(User user) {
		try {
			if (userRepository.findOne(user.getIdUser()) != null) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

}
