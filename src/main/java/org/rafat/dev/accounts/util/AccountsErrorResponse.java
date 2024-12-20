package org.rafat.dev.accounts.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsErrorResponse {

    private HttpStatus errorCode;
    private String apiPath;
    private String message;
    private LocalDateTime errorTime;
}
