package com.example.SimpleBankingApp.service;

import com.example.SimpleBankingApp.dto.AccountDto;

import java.util.List;

public interface AccountService {
AccountDto createAccount(AccountDto accountDto);
 AccountDto getAccountById(Long id);
 AccountDto deposit(Long id,double amount);
 AccountDto withdraw(Long id,double amount);
 List<AccountDto> getAllAccounts();
 void deleteAccount(Long id);

}
