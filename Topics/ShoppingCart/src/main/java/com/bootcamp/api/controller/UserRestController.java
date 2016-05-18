package com.bootcamp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.api.entities.Product;
import com.bootcamp.api.entities.Purchase;
import com.bootcamp.api.entities.User;
import com.bootcamp.api.services.ProductService;
import com.bootcamp.api.services.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
@Api(value = "Users", description = "Users API")
public class UserRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	/*
	 * public UsersRestController() { userService = new UserServiceImpl();
	 * productService = new ProductServiceImpl(); }
	 */

	@ApiOperation(value = "Login user", response = User.class, notes = "Returns the user specified by username and password.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User logged in."),
            @ApiResponse(code = 404, message = "User not found.")
    })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody String username, @RequestBody String password) {
		try {
			return new ResponseEntity<User>(userService.validate(username, password), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Register user", response = User.class, notes = "Returns the registered user.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "User registered."),
            @ApiResponse(code = 501, message = "Username is not available.")
    })
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> register(@RequestBody User user) {
		if (userService.isUsernameAvailable(user.getUsername())) {
			return new ResponseEntity<User>(userService.add(user), HttpStatus.CREATED);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	
	@ApiOperation(value = "Remove user", notes = "Remove the specified user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User removed."),
            @ApiResponse(code = 404, message = "User not found.")
    })
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> removeUser(@RequestBody User user){
		if (userService.exists(user)) {
			userService.remove(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Update user", response = User.class, notes = "Returns the user updated.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User updated."),
            @ApiResponse(code = 304, message = "User not updated.")
    })
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user){
			if (userService.isUsernameAvailable(user.getUsername())) {
				return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
			}else return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	@ApiOperation(value = "Get all the users", response = List.class, notes = "Returns a list within all the existing users.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User list returned."),
            @ApiResponse(code = 404, message = "User list is empty.")
    })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAll();
		if (!users.isEmpty()) {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Get user by its username", response = User.class, notes = "Returns the user specified by its username.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "User found."),
            @ApiResponse(code = 404, message = "User not found.")
    })
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
		User user = userService.getByUsername(username);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Add to cart.", notes = "Adds a product to the cart of the specified user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Product added correctly."),
            @ApiResponse(code = 501, message = "The username or the IDProduct aren't correct.")
    })
	@RequestMapping(value = "/{username}/cart/{idProduct}", method = RequestMethod.POST)
	public ResponseEntity<?> addToCart(@PathVariable String username, @PathVariable Integer idProduct) {
		User user = userService.getByUsername(username);
		Product product = productService.getById(idProduct);
		if (product != null && user != null) {
			user.getCart().add(product);
			userService.update(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "Remove from cart.", notes = "Removes a product from the cart of the specified user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Product removed."),
            @ApiResponse(code = 501, message = "The username or the IDProduct aren't correct.")
    })
	@RequestMapping(value = "/{username}/cart/{idProduct}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeFromCart(@PathVariable String username, @PathVariable Integer idProduct) {
		User user = userService.getByUsername(username);
		Product product = productService.getById(idProduct);
		if (product != null && user != null) {
			user.getCart().remove(product);
			userService.update(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "Clear cart.", notes = "Removes all the products from the cart of the specified user.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cart cleared."),
            @ApiResponse(code = 501, message = "The username is not correct.")
    })
	@RequestMapping(value = "/{username}/cart", method = RequestMethod.DELETE)
	public ResponseEntity<User> clearCart(@PathVariable String username){
		if (!userService.isUsernameAvailable(username)) {
			User user = userService.getByUsername(username);
			user.getCart().clear();
			return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
		} else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "Purchase cart content.", notes = "Returns a purchase within the cart's product list.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Purchase done."),
            @ApiResponse(code = 501, message = "The username is not correct.")
    })
	@RequestMapping(value = "/{username}/cart", method = RequestMethod.POST)
	public ResponseEntity<Purchase> purchaseCartContent(@PathVariable String username){
		if (!userService.isUsernameAvailable(username)) {
			User user = userService.getByUsername(username);
			Purchase purchase = user.getCart().buy();
			return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
		}else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
