package com.academy.service;

import com.academy.entity.Customer;
import com.academy.exception.CustomerNotAdultException;
import com.academy.exception.ValidationException;
import com.academy.service.ReusableValidator;


public class CustomerAdultValidator extends ReusableValidator<Customer> {
    @Override
    public void validate(Customer customer){
        if(customer.getAge() < 18){
            throw new ValidationException("Customer is not adult, he is: " + customer.getAge());
        }
    }

}







