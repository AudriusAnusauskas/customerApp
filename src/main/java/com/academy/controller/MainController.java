package com.academy.controller;

import com.academy.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.academy.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
        return customerService.fetchCustomers();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }
}