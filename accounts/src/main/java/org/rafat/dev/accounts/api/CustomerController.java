package org.rafat.dev.accounts.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.rafat.dev.accounts.dto.CustomerDto;
import org.rafat.dev.accounts.service.CustomerService;
import org.rafat.dev.accounts.util.AccountsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Validated
@AllArgsConstructor
@Tag(name = "CRUD Operation on Customer")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/list")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(description = "Create customer and add new account")
    @ApiResponse(responseCode = "201", description = "Http status created")
    public ResponseEntity<AccountsResponse<CustomerDto>> createCustomer(@RequestBody @Valid CustomerDto customerDto){
        CustomerDto customer = customerService.createCustomer(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AccountsResponse<>(HttpStatus.CREATED.name(), "", customer));
    }

    @GetMapping
    public ResponseEntity<AccountsResponse<CustomerDto>> getCustomerByMobileNumber(@RequestParam
                                                                                   @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number should be 10 digits.")
                                                                                   String mobile){
        CustomerDto customerDto = customerService.getCustomerByMobileNumber(mobile);

        AccountsResponse<CustomerDto> accountsResponse = new AccountsResponse<>();
        accountsResponse.setData(customerDto);
        accountsResponse.setStatusCode(HttpStatus.OK.name());

        return ResponseEntity.status(HttpStatus.OK)
                .body(accountsResponse);
    }


}
