package org.rafat.dev.accounts.dao;

import org.rafat.dev.accounts.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao extends BaseDao<Account> {

    public AccountDao() {
        super();
        setClazz(Account.class);
    }
}
