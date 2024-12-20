package org.rafat.dev.accounts.dao;

import org.rafat.dev.accounts.model.Account;
import org.rafat.dev.accounts.model.Customer;

import java.util.List;

public interface AccountDao {

    Account getById(Long id);

    List<Account> findAll();

    Account create(Account Account);

    Account saveOrUpdate(Account account);

    Account getAccountByCustomerId(Long customerId);
}
