package com.service;

import com.model.Account;
import com.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String accountNo, String name, double amount) {
        if (amount <= 1000) {
            throw new IllegalArgumentException("Amount must be greater than 1000");
        }

        if (accountRepository.existsById(accountNo)) {
            throw new IllegalArgumentException("Account number must be unique");
        }

        Account account = new Account(accountNo, name, amount);
        return accountRepository.save(account);
    }

    public String deposit(String accountNo, double amount, String panCardNumber) {
        if (amount > 50000) {
            if (panCardNumber == null || panCardNumber.isEmpty()) {
                return "PAN card number required for deposits over 50,000";
            }
        }

        Account account = accountRepository.findById(accountNo)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        account.setAmount(account.getAmount() + amount);
        accountRepository.save(account);
        return "Deposit successful";
    }

    public String withdraw(String accountNo, double amount) {
        Account account = accountRepository.findById(accountNo)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (account.getAmount() - amount < 1000) {
            return "Insufficient funds to maintain minimum balance";
        }

        account.setAmount(account.getAmount() - amount);
        accountRepository.save(account);
        return "Withdrawal successful";
    }

    public double checkBalance(String accountNo) {
        Account account = accountRepository.findById(accountNo)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        return account.getAmount();
    }
}
