package com.nag.nagp.devopsassignment.domain;

import com.nag.nagp.devopsassignment.dto.CustomerDto;
import com.nag.nagp.devopsassignment.entity.Customer;
import com.nag.nagp.devopsassignment.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testShouldBeAbleToSaveCustomerDetails() {
        Customer customerSaved = new Customer();
        customerSaved.setCustomerId(1L);
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customerSaved);

        Long customerIdResponse = customerService.saveCustomer(new CustomerDto());
        Assert.assertNotNull(customerIdResponse);
        Assert.assertEquals(Optional.of(1L), java.util.Optional.of(customerIdResponse));
    }

    @Test
    public void testShouldBeAbleToFetchAllCustomers() {
        Customer customerSaved = new Customer();
        customerSaved.setCustomerId(1L);
        Mockito.when(customerRepository.findAll()).thenReturn(Arrays.asList(customerSaved));

        List<CustomerDto> response = customerService.fetchAllCustomers();
        Assert.assertNotNull(response);
        Assert.assertEquals(1, response.size());
    }
}
