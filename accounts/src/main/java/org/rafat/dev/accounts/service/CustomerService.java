package org.rafat.dev.accounts.service;

import org.rafat.dev.accounts.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long id);

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerByMobileNumber(String mobile);
}
