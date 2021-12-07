package com.nag.nagp.devopsassignment.integration.domain;

import com.nag.nagp.devopsassignment.domain.CustomerService;
import com.nag.nagp.devopsassignment.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CustomerServiceIntegrationTests {
    @LocalServerPort
    private int port;

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testGetAllCveItems()
    {
        HttpEntity entity = new HttpEntity<>(null, headers);
        ResponseEntity responseEntity = testRestTemplate.exchange(createURLWithPort(
                "/api/v1/customer/"), HttpMethod.GET, entity, String.class);
        assertNotNull(responseEntity);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


    private String createURLWithPort(String uri)
    {
        return "http://localhost:" + port + uri;
    }
}
