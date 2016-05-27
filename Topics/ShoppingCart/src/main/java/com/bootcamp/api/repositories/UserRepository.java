package com.bootcamp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
