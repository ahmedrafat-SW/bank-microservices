package org.rafat.dev.accounts.dao;

import org.rafat.dev.accounts.model.Customer;

import java.util.List;

public interface CustomerDao {

    Customer getCustomerByMobileNumber(String mobileNumber);

    Customer getById(Long id);

    List<Customer> findAll();

    Customer create(Customer customer);

    Customer saveOrUpdate(Customer customer);

    void delete(Customer customer);

    void delete(Long id);

}
