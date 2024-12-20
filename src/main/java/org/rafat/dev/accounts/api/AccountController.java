package org.rafat.dev.accounts.api;

import org.rafat.dev.accounts.dto.AccountDto;
import org.rafat.dev.accounts.model.Account;
import org.rafat.dev.accounts.service.AccountService;
import org.rafat.dev.accounts.service.impl.AccountServiceImpl;
import org.rafat.dev.accounts.util.AccountsResponse;
import org.rafat.dev.accounts.util.AccountsResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public AccountDto getAllAccounts(@PathVariable Long id) {
        return accountService.getById(id);
    }

    @GetMapping("/list")
    public List<AccountDto> getAccountList() {
        return accountService.getAccountList();
    }

    @PostMapping
    public ResponseEntity<AccountsResponse<AccountDto>> createAccount(@RequestBody AccountDto accountDto){
        accountService.createAccount(accountDto);
        AccountsResponse<AccountDto> accountsResponse = new AccountsResponse<>
                (AccountsResponseCode.ACCOUNT_CREATED.getCode(), AccountsResponseCode.ACCOUNT_CREATED.getMessage(), accountDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(accountsResponse);
    }
}
