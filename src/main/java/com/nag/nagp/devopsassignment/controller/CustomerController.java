package com.nag.nagp.devopsassignment.controller;

import com.nag.nagp.devopsassignment.domain.CustomerService;
import com.nag.nagp.devopsassignment.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public Long saveCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping("/")
    public List<CustomerDto> fetchAllCustomers() {
        return customerService.fetchAllCustomers();
    }
}
