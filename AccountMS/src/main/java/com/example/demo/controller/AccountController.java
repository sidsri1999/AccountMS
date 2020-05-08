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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AccountRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.dto.AccountDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.services.AccountServiceImpl;
import com.example.demo.util.Status;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountServiceImpl service;
	
	@GetMapping("/getallaccounts")
	ResponseEntity<List<Account>> getAllAccounts(){
		List<Account> accounts = service.getAllAccounts();
		ResponseEntity<List<Account>> response = new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getaccount/{id}")
	ResponseEntity<Account> getAccount(@PathVariable("id") int accountId){
		Account account = service.getAccount(accountId);
		ResponseEntity<Account> response = new ResponseEntity<Account>(account,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/deleteaccount/{id}")
	ResponseEntity<Void> deleteAccount(@PathVariable("id") int accountId){
		Boolean status = service.deleteAccount(accountId);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}
	
	@PutMapping("updateaccount/{id}")
	ResponseEntity<Account> updateAccount(@PathVariable("id") int accountId,AccountDto accountDto){
		Account account = service.updateAccount(accountId, accountDto);
		ResponseEntity<Account> response = new ResponseEntity<Account>(HttpStatus.OK);
		return response;
	}
	
}