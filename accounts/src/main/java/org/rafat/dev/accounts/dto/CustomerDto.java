package org.rafat.dev.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class CustomerDto {

    @NotEmpty
    @Size(min = 5, max = 50, message = "the length of customer name should be between 5 and 50 characters.")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number should be 10 digits.")
    private String mobileNumber;

    private AccountDto accountDto;
}
