package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.User;

public interface IUserService {
	
	public User addUser(UserDto userDto);
	
	public User getUser(int userId);
	
	public List<User> getAllUsers();
	
	public boolean deleteUser(int userId);
	
	public User updateUserPassword(int userId, UserDto userDto);
	
	public Account addAccount(int userId);
	
}
