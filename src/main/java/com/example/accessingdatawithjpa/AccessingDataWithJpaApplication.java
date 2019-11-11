package com.example.accessingdatawithjpa;

import com.example.accessingdatawithjpa.repository.Customer;
import com.example.accessingdatawithjpa.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
public class AccessingDataWithJpaApplication {

    private static final Logger logger = LoggerFactory.getLogger(AccessingDataWithJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataWithJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CustomerRepository repository) {
        return args -> {
            // save customers
            repository.save(new Customer("Mahanta"));
            repository.save(new Customer("Samnateyu"));
            repository.save(new Customer("Dhritimitra"));
            repository.save(new Customer("Somakirti"));

            // retrieve all
            logger.info("Customers found with findAll():");
            logger.info("-------------------------------");
            Iterable<Customer> customers = repository.findAll();
            customers.forEach(customer -> {
                logger.info(customer.toString());
            });
            logger.info("");

            // retrieve by name
            logger.info("Customers found with findByFirstName(\"name\"):");
            logger.info("-------------------------------");
            repository.findByFirstName("Dhritimitra").forEach(customer -> logger.info(customer.toString()));
            logger.info("");

            // retrieve by id
            logger.info("Customer found with findById(4):");
            logger.info("--------------------------------");
            Customer customer = repository.findById(4);
            logger.info(customer.toString());
            logger.info("");
        };
    }
}
