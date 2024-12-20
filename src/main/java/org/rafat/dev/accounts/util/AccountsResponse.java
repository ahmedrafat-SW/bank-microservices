package org.rafat.dev.accounts.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsResponse<T> {

    private String statusCode;
    private String message;
    private T data;
}
