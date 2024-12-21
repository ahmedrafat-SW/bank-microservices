package org.rafat.dev.accounts.exception;

import jakarta.validation.ConstraintViolationException;
import org.rafat.dev.accounts.util.AccountsErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        List<ObjectError> allErrors = ex.getAllErrors();
        allErrors.forEach(error -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

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
