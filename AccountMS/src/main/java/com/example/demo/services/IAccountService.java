package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Account;

public interface IAccountService {
	
	public Account addAccount(int userId);
	
	public Account getAccount(int accountId);
	
	public List<Account> getAllAccounts();
	
	public boolean deleteAccount(int accountId);
	
	public Account updateAccount(int accountId,AccountDto accountDto);

}
