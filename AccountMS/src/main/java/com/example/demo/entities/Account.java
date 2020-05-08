package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.example.demo.util.Status;

@Component
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int accountId;
	double accountBalance;
	Status status;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountId, double accountBalance, Status status) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.status = status;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountBalance=" + accountBalance + ", status=" + status + "]";
	}
	
	
}
