package com.nag.nagp.devopsassignment.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerDto {
    @NotNull
    private String name;
    private Integer age;
    private Long customerId;
}
