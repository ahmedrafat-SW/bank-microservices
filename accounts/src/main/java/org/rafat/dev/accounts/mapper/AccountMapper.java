package org.rafat.dev.accounts.mapper;

import org.rafat.dev.accounts.dto.AccountDto;
import org.rafat.dev.accounts.model.Account;

public class AccountMapper {

    public static AccountDto mapToDto(Account account) {
        AccountDto dto = new AccountDto();

        dto.setAccountType(account.getAccountType());
        dto.setAccountAddress(account.getAccountAddress());
        dto.setAccountNumber(account.getAccountNumber());

        return dto;
    }


    public static Account mapToEntity(AccountDto dto){
        Account account = new Account();

        account.setAccountNumber(dto.getAccountNumber());
        account.setAccountType(dto.getAccountType());
        account.setAccountAddress(dto.getAccountAddress());

        return account;
    }
}
