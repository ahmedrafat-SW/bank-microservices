package org.rafat.dev.accounts.controller;

import org.rafat.dev.accounts.model.Account;
import org.rafat.dev.accounts.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAllAccounts(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @GetMapping("")
    public List<Account> getAccountList() {
        return accountService.getAccountList();
    }
}
