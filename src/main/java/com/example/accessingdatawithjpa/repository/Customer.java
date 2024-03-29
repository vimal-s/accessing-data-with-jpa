package com.example.accessingdatawithjpa.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
//    private String lastName;

    public Customer() {        // not public because we'll not be using it, present only for the sake of spring jpa
    }

    public Customer(String firstName/*, String lastName*/) {
        this.firstName = firstName;
//        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s']", id, firstName/*, lastName*/);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    /*public String getLastName() {
        return lastName;
    }*/
}