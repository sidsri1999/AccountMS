package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserRepo;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.util.Status;

@Component
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	AccountServiceImpl accountService;

	@Override
	public User addUser(UserDto userDto) {
		List<User> users = getAllUsers();
		for(User user : users) {
			if(user.getPhoneNumber().equals(userDto.getPhoneNumber())){
				return null;
			}
		}
		User user = new User();
		user.setLoginName(userDto.getLoginName());
		user.setPassword(userDto.getPassword());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setUserName(userDto.getPhoneNumber()+"@ow");
		User user1 = userRepo.save(user);
		return user1;
	}

	@Override
	public User getUser(int userId) {
		User user = userRepo.getOne(userId);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public boolean deleteUser(int userId) {
		User user = userRepo.getOne(userId);
		Account account = user.getAccount();
		accountService.deleteAccount(account.getAccountId());
		userRepo.deleteById(userId);
		return true;
	}

	@Override
	public User updateUserPassword(int userId, UserDto userDto) {
		User user = userRepo.getOne(userId);
		if(user.getUserName().equals(userDto.getUserName()) && user.getLoginName().equalsIgnoreCase(userDto.getLoginName())) {
			user.setPassword(userDto.getPassword());
			User user2 = userRepo.save(user);
			return user2;
		}
		return null;
	}
	
	@Override
	public Account addAccount(int userId) {
		User user = userRepo.getOne(userId);
		Account account = accountService.addAccount(userId);
		user.setAccount(account);
		userRepo.save(user);
		return account;
	}

}
