package org.rafat.dev.accounts.service.impl;

import lombok.AllArgsConstructor;
import org.rafat.dev.accounts.dao.AccountDao;
import org.rafat.dev.accounts.dao.CustomerDao;
import org.rafat.dev.accounts.dto.AccountDto;
import org.rafat.dev.accounts.dto.CustomerDto;
import org.rafat.dev.accounts.exception.CustomerAlreadyExistsException;
import org.rafat.dev.accounts.exception.ResourceNotFoundException;
import org.rafat.dev.accounts.mapper.AccountMapper;
import org.rafat.dev.accounts.mapper.CustomerMapper;
import org.rafat.dev.accounts.model.Account;
import org.rafat.dev.accounts.model.Customer;
import org.rafat.dev.accounts.service.CustomerService;
import org.rafat.dev.accounts.util.enums.AccountType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;
    private final AccountDao accountDao;

    public List<CustomerDto> getAllCustomers(){
        List<Customer> customers = customerDao.findAll();

        return customers.stream().map(CustomerMapper::mapToDto).toList();
    }

    public CustomerDto getCustomerById(Long id){
        return CustomerMapper.mapToDto(customerDao.getById(id));
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToEntity(customerDto);

        Customer customerByMobileNumber = customerDao.getCustomerByMobileNumber(customer.getMobileNumber());
        if (customerByMobileNumber != null){
            throw new CustomerAlreadyExistsException("Customer with provided mobile number already exists.");
        }

        customer = customerDao.create(customer);
        AccountDto accountDto = AccountMapper.mapToDto(createAccountForNewCustomer(customer));
        CustomerDto dto = CustomerMapper.mapToDto(customer);
        dto.setAccountDto(accountDto);

        return dto;
    }

    private Account createAccountForNewCustomer(Customer customer) {
        long accountNumber = 1000000000L + Math.abs(new Random().nextLong());
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountType(AccountType.SAVING.getName());
        account.setAccountAddress("Cairo, Egypt");
        account.setCreatedBy(customer.getName());
        account.setCustomerId(customer.getCustomerId());

        return accountDao.saveOrUpdate(account);
    }

    @Override
    public CustomerDto getCustomerByMobileNumber(String mobile) {
        Customer customer = customerDao.getCustomerByMobileNumber(mobile);
        if (customer == null){
            throw new ResourceNotFoundException("Customer", "mobile number" ,mobile);
        }

        Account account = accountDao.getAccountByCustomerId(customer.getCustomerId());

        if (account == null){
            throw new ResourceNotFoundException("Account", "mobile number", mobile);
        }

        CustomerDto customerDto = CustomerMapper.mapToDto(customer);
        customerDto.setAccountDto(AccountMapper.mapToDto(account));

        return customerDto;
    }
}
