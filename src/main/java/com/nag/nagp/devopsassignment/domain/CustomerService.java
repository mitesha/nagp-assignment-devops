package com.nag.nagp.devopsassignment.domain;

import com.nag.nagp.devopsassignment.dto.CustomerDto;
import com.nag.nagp.devopsassignment.entity.Customer;
import com.nag.nagp.devopsassignment.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Long saveCustomer(CustomerDto customerDto) {
        log.info("Saving customer details for customer {}", customerDto);
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setAge(customerDto.getAge());
        Customer savedCustomer = customerRepository.save(customer);
        log.info("Customer saved");
        return savedCustomer.getCustomerId();
    }

    public List<CustomerDto> fetchAllCustomers() {
        log.info("Fetch All customers");
        List<Customer> customers = customerRepository.findAll();

        if (customers == null || customers.isEmpty()) {
            return Collections.emptyList();
        }

        return customers.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private CustomerDto convertEntityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setAge(customer.getAge());
        customerDto.setName(customer.getName());
        customerDto.setCustomerId(customer.getCustomerId());
        return customerDto;
    }
}
