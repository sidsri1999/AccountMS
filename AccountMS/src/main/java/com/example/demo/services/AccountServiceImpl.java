package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.AccountRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.util.Status;

@Component
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	UserServiceImpl userService;
	
	@Override
	@Transactional
	public Account addAccount(int userId) {
		User user1 = userService.getUser(userId);
		Account account = new Account();
		account.setAccountBalance(0);
		account.setStatus(Status.FALSE);
		user1.setAccount(account);
		Account account1 = accountRepo.save(account);
		return account;
	}

	@Override
	public Account getAccount(int accountId) {
		Account account = accountRepo.getOne(accountId);
		return account;
	}

	@Override
	@Transactional
	public boolean deleteAccount(int accountId) {
		accountRepo.deleteById(accountId);
		return true;
	}

	@Override
	@Transactional
	public Account updateAccount(int accountId, AccountDto accountDto) {
		Account account = accountDtoToEntity(accountDto);
		account.setAccountId(accountId);
		accountRepo.save(account);
		return account;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> account = accountRepo.findAll();
		return account;
	}
	
	public User userDtoToEntity(UserDto userDto) {
		User user = new User();
		user.setUserName(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setLoginName(userDto.getLoginName());
		return user;
	}
	
	public Account accountDtoToEntity(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountBalance(accountDto.getAccountBalance());
		account.setStatus(accountDto.getStatus());
		return account;
	}

}
