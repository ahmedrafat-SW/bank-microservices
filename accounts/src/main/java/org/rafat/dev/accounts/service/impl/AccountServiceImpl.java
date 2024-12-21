package org.rafat.dev.accounts.service.impl;

import lombok.AllArgsConstructor;
import org.rafat.dev.accounts.dto.AccountDto;
import org.rafat.dev.accounts.mapper.AccountMapper;
import org.rafat.dev.accounts.model.Account;
import org.rafat.dev.accounts.dao.impl.AccountDaoImpl;
import org.rafat.dev.accounts.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountDaoImpl accountDaoImpl;

    public List<AccountDto> getAccountList() {
        List<Account> accounts = accountDaoImpl.findAll();

        return accounts.stream()
                .map(AccountMapper::mapToDto)
                .toList();
    }


    public AccountDto getById(Long id){
        return AccountMapper.mapToDto(accountDaoImpl.getById(id));
    }

    public void createAccount(AccountDto accountDto) {
        accountDaoImpl.create(AccountMapper.mapToEntity(accountDto));
    }
}