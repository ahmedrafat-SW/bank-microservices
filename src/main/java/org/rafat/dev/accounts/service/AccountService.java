package org.rafat.dev.accounts.service;

import org.rafat.dev.accounts.model.Account;
import org.rafat.dev.accounts.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional(readOnly = true)
    public List<Account> getAccountList() {
        return accountDao.findAll();
    }


    public Account getById(Long id){
        return accountDao.findOne(id);
    }
}