package com.nag.nagp.devopsassignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMERID")
    private Long customerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "CREATEDON")
    private LocalDateTime createdOn;
    @Column(name = "UPDATEDON")
    private LocalDateTime updatedOn;

    @PrePersist
    public void setCreatedDate(){
        this.createdOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdatedDate(){
        this.updatedOn = LocalDateTime.now();
    }
}
