package com.example.accessingdatawithjpa;

import com.example.accessingdatawithjpa.repository.Customer;
import com.example.accessingdatawithjpa.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest      // use this instead , if wanna use TestEntityManager
public class AccessingDataWithJpaApplicationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findByNameShouldReturnName() {
        Customer customer = new Customer("Test_User");
//        System.out.println(customer.getId() + "hello");

        entityManager.persist(customer);
//		customerRepository.save(customer);
//        System.out.println(customer.getId() + "bye");

        List<Customer> customerList = customerRepository.findByFirstName("Test_User");
        assertThat(customerList).extracting(Customer::getFirstName).containsOnly(customer.getFirstName());
        assertThat(customerList).extracting(Customer::getId).containsOnly(customer.getId());
    }
}
