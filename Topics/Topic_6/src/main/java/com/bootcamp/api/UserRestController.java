package com.bootcamp.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.entities.Sale;
import com.bootcamp.entities.SaleItem;
import com.bootcamp.entities.User;
import com.bootcamp.services.ServiceSaleItem;
import com.bootcamp.services.ServiceUser;
import com.bootcamp.services.impl.ServiceSaleItemImpl;
import com.bootcamp.services.impl.ServiceUserImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "Users", description = "Api for users")
@RestController
@RequestMapping("/users")
public class UserRestController {
	@Autowired
	ServiceSaleItem serviceSaleItem;
	@Autowired
	ServiceUser serviceUser;
	
	
	public UserRestController(){
		serviceSaleItem = new ServiceSaleItemImpl();
		serviceUser = new ServiceUserImpl();
	}
	
	@ApiOperation(value = "Get user by ID.", response = User.class, notes = "Returns the user looked for its ID.")
	@RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
	ResponseEntity<User> getUserById(@PathVariable String idUser){
		User user = serviceUser.getUserById(idUser);
		if(user!=null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Update an user.", response = HttpStatus.class, notes = "Updates the user specified in the request's body.")
	@RequestMapping(method = RequestMethod.PUT)
	ResponseEntity<?> updateUser(@RequestBody User user){
		if(serviceUser.updateUser(user))
			return new ResponseEntity<>(HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	@ApiOperation(value = "Delete an user.", response = HttpStatus.class, notes = "Deletes the user specified by its ID in the URI.")
	@RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
	ResponseEntity<?> deleteUser(@PathVariable String idUser){
		if(serviceUser.deleteUser(idUser))
			return new ResponseEntity<>(HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Add an user.", response = HttpStatus.class, notes = "Adds the user specified in the request's body.")
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addUser(@RequestBody User user){
		if(serviceUser.addNewUser(user))
			return new ResponseEntity<>(HttpStatus.CREATED);
		else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "Add an item to cart by its ID.", response = HttpStatus.class, notes = "Adds the specified item to the specified user's cart, both in the URI.")
	@RequestMapping(value = "/{idUser}/cart/{idItem}", method = RequestMethod.POST)
	ResponseEntity<?> addToCartById(@PathVariable String idUser, @PathVariable int idItem){
		User user = serviceUser.getUserById(idUser);
		SaleItem saleItem = serviceSaleItem.getSaleItemById(idItem);
		if (saleItem!=null) {
			if (user.getCart().add(saleItem)) {
				if(serviceUser.updateUser(user)){
					return new ResponseEntity<>(HttpStatus.OK);
				}
				else return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
			else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@ApiOperation(value = "Remove an item from cart by its ID", response = HttpStatus.class, notes = "Removes the specified item from the specified user's cart, both in the URI." )
	@RequestMapping(value = "/{idUser}/cart/{idItem}", method = RequestMethod.DELETE)
	ResponseEntity<?> removeFromCartById(@PathVariable String idUser, @PathVariable int idItem){
		User user = serviceUser.getUserById(idUser);
		SaleItem saleItem = serviceSaleItem.getSaleItemById(idItem);
		if (saleItem!=null) {
			if (user.getCart().remove(saleItem)) {
				if(serviceUser.updateUser(user)){
					return new ResponseEntity<>(HttpStatus.OK);
				}
				else return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
			else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@ApiOperation(value = "Buy cart content.", response = Sale.class, notes = "Returns a Sale object, which contains the list of items of the cart. Clears the cart, too!")
	@RequestMapping(value = "/{idUser}/cart/buy", method = RequestMethod.POST)
	ResponseEntity<Sale> buyCartContent(@PathVariable String idUser){
		User user = serviceUser.getUserById(idUser);
		Sale sale = user.getCart().buy();
		user.getCart().clearCart();
		if(serviceUser.updateUser(user))
			return new ResponseEntity<Sale>(sale, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ApiOperation(value = "Clear the cart.", response = HttpStatus.class, notes = "Clears the specified user's cart in the URI.")
	@RequestMapping(value = "/{idUser}/cart", method = RequestMethod.DELETE)
	ResponseEntity<?> clearCart(@PathVariable String idUser){
		User user = serviceUser.getUserById(idUser);
		user.getCart().clearCart();
		if(serviceUser.updateUser(user))
			return new ResponseEntity<>(HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	@ApiOperation(value = "Get cart content.", response = ArrayList.class, notes = "Returns an arraylist within the cart's items.")
	@RequestMapping(value = "/{idUser}/cart", method = RequestMethod.GET)
	ResponseEntity<ArrayList<SaleItem>> getCartContent(@PathVariable String idUser){
		User user = serviceUser.getUserById(idUser);
		if (!user.getCart().getItems().isEmpty())
			return new ResponseEntity<ArrayList<SaleItem>>(user.getCart().getItems(), HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
