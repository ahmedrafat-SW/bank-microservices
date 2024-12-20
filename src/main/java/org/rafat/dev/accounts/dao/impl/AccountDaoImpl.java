package org.rafat.dev.accounts.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.rafat.dev.accounts.dao.AccountDao;
import org.rafat.dev.accounts.dao.BaseDao;
import org.rafat.dev.accounts.model.Account;
import org.rafat.dev.accounts.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {


    @Override
    public Account getById(Long id) {
        return findById(id);
    }

    @Override
    public Account getAccountByCustomerId(Long customerId) {
        Session session = getSession();

        Query<Account> query = session.createQuery("select a from Account a where a.customerId =: id", Account.class);
        query.setParameter("id", customerId);

        return query.uniqueResult();
    }
}
