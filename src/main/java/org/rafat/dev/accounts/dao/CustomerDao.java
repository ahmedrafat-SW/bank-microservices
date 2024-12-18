package org.rafat.dev.accounts.dao;

import jakarta.transaction.Transactional;
import org.rafat.dev.accounts.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CustomerDao extends BaseDao<Customer> {

    public CustomerDao() {
        super();
        setClazz(Customer.class);
    }
}
