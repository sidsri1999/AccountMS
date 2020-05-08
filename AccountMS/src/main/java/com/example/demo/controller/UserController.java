package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.services.AccountServiceImpl;
import com.example.demo.services.UserServiceImpl;

@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/adduser")
	ResponseEntity<User> addUser(@RequestBody UserDto userDto){
		User user = service.addUser(userDto);
		ResponseEntity<User> response = new ResponseEntity<User>(user,HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/getallusers")
	ResponseEntity<List<User>> getAllUsers(){
		List<User> users = service.getAllUsers();
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(users,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getuser/{id}")
	ResponseEntity<User> getAccount(@PathVariable("id") int userId){
		User user = service.getUser(userId);
		ResponseEntity<User> response = new ResponseEntity<User>(user,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/deleteuser/{id}")
	ResponseEntity<Void> deleteAccount(@PathVariable("id") int userId){
		Boolean status = service.deleteUser(userId);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@PutMapping("addaccount/{id}")
	ResponseEntity<Account> updateAccount(@PathVariable("id") int userId){
		Account account = service.addAccount(userId);
		ResponseEntity<Account> response = new ResponseEntity<Account>(HttpStatus.OK);
		return response;
	}
	
	@PutMapping("changepassword/{id}")
	ResponseEntity<User> changePassword(@PathVariable("id") int userId,@RequestBody UserDto userDto){
		User user = service.updateUserPassword(userId, userDto);
		ResponseEntity<User> response = new ResponseEntity<User>(user,HttpStatus.OK);
		return response;
	}

}
