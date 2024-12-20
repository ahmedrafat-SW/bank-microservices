package org.rafat.dev.accounts.exception;

import org.rafat.dev.accounts.util.AccountsErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<AccountsErrorResponse> handleCustomerAlreadyExistException(CustomerAlreadyExistsException exception , WebRequest request){

        AccountsErrorResponse accountsErrorResponse = new AccountsErrorResponse();
        accountsErrorResponse.setErrorCode(HttpStatus.BAD_REQUEST);
        accountsErrorResponse.setErrorTime(LocalDateTime.now());
        accountsErrorResponse.setMessage(exception.getMessage());
        accountsErrorResponse.setApiPath(request.getDescription(false));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(accountsErrorResponse);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AccountsErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
        AccountsErrorResponse accountsErrorResponse = new AccountsErrorResponse();
        accountsErrorResponse.setErrorCode(HttpStatus.NOT_FOUND);
        accountsErrorResponse.setErrorTime(LocalDateTime.now());
        accountsErrorResponse.setMessage(exception.getMessage());
        accountsErrorResponse.setApiPath(request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountsErrorResponse);
    }
}
