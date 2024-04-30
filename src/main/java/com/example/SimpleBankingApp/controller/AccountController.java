package com.example.SimpleBankingApp.controller;

import com.example.SimpleBankingApp.dto.AccountDto;
import com.example.SimpleBankingApp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(Long id){
        AccountDto accountDto =accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);

    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id, request.get("amount"));
        return  ResponseEntity.ok(accountDto);


    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, request.get("amount"));
        return ResponseEntity.ok(accountDto);

    }
    @GetMapping
    public  ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts= accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is successfully deleted");
    }
}
