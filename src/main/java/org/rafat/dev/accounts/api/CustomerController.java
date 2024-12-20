package org.rafat.dev.accounts.api;

import org.rafat.dev.accounts.dto.AccountDto;
import org.rafat.dev.accounts.dto.CustomerDto;
import org.rafat.dev.accounts.service.CustomerService;
import org.rafat.dev.accounts.util.AccountsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/list")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountsResponse<CustomerDto>> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customer = customerService.createCustomer(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AccountsResponse<>(HttpStatus.CREATED.name(), "", customer));
    }

    @GetMapping
    public ResponseEntity<AccountsResponse<CustomerDto>> getCustomerByMobileNumber(@RequestParam String mobile){
        CustomerDto customerDto = customerService.getCustomerByMobileNumber(mobile);

        AccountsResponse<CustomerDto> accountsResponse = new AccountsResponse<>();
        accountsResponse.setData(customerDto);
        accountsResponse.setStatusCode(HttpStatus.OK.name());

        return ResponseEntity.status(HttpStatus.OK)
                .body(accountsResponse);
    }


}
