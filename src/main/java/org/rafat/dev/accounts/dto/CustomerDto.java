package org.rafat.dev.accounts.dto;

import lombok.*;

@Data
public class CustomerDto {

    private String name;

    private String email;

    private String mobileNumber;

    private AccountDto accountDto;
}
