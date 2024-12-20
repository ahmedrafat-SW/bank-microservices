package org.rafat.dev.accounts.service;

import org.rafat.dev.accounts.dto.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAccountList();
    AccountDto getById(Long id);
    void createAccount(AccountDto accountDto);
}
