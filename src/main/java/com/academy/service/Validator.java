package com.academy.service;

import com.academy.entity.Customer;
import com.academy.exception.MandatoryValueMissingException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Validator {
    public void validate(Customer customer){
        if(customer.getLastName().isEmpty() ){
            throw new MandatoryValueMissingException("Missing Last Name");
        } else if (customer.getFirstName().isEmpty()) {
            throw new MandatoryValueMissingException("Missing First Name");
        } else if (customer.getPersonalNumber().isEmpty()){
            throw new MandatoryValueMissingException("Missing Personal Number");
        } else if(customer.getAge() < 18){
            try {
                throw new CustomerNotAdultException("Customer is not Adult");
            } catch (CustomerNotAdultException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
