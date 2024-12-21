package org.rafat.dev.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
public class AccountDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "account number should be 10 digits.")
    private Long accountNumber;

    @NotEmpty(message = "account type should not be empty or null.")
    private String accountType;

    @NotEmpty(message = "account address should not be empty or null.")
    private String accountAddress;

}
