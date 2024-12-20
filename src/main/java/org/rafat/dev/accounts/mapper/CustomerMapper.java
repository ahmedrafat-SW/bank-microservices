package org.rafat.dev.accounts.mapper;

import org.rafat.dev.accounts.dto.CustomerDto;
import org.rafat.dev.accounts.model.Customer;

public class CustomerMapper {

    public static CustomerDto mapToDto(Customer customer) {
        CustomerDto dto  = new CustomerDto();

        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setMobileNumber(customer.getMobileNumber());

        return dto;
    }


    public static Customer mapToEntity(CustomerDto dto) {
        Customer customer = new Customer();

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setMobileNumber(dto.getMobileNumber());

        return customer;
    }

}
