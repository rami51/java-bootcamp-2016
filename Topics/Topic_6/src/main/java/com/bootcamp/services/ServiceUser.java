package com.bootcamp.services;

import com.bootcamp.entities.User;

public interface ServiceUser {
	/**
	 * Returns a specific user, searched by the identification.
	 * @param id of the user.
	 * @return a user object. if it has not been found, returns null.
	 */
	public User getUserById(String idUser);

	/**
	 * Updates an existing user in database.
	 * @param userUpdate the existing user with the modification to save
	 * @return true if the user has been updated, otherwise returns false.
	 */
	public boolean updateUser(User userUpdate);

	/**
	 * Deletes an existing user in database.
	 * @param the id of user will be deleted
	 * @return true if the user has been deleted, otherwise returns false.
 	 */
	public boolean deleteUser(String idUser);

	/**
	 * Adds a new user to database
	 * @param the user will be added
	 * @return true if the user has been added, otherwise returns false.
	 */
	public boolean addNewUser(User user);
}
