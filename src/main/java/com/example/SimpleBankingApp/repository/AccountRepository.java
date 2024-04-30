package com.example.SimpleBankingApp.repository;

import com.example.SimpleBankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
