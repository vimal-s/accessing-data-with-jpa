package com.example.accessingdatawithjpa.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //    @Query("select * from Customer d")
    List<Customer> findByFirstName(String name);    // need matching name or query else will get error

    Customer findById(long id);
}