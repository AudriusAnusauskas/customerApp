package com.academy.service;

import com.academy.entity.Customer;
import com.academy.exception.MandatoryValueMissingException;
import com.academy.exception.ValidationException;

public class MandatoryCustomerValuesValidator extends ReusableValidator<Customer> {
    @Override
    public void validate(Customer customer) {
        if(customer.getLastName().isEmpty() ){
            throw new ValidationException("Missing Last Name");
        } else if (customer.getFirstName().isEmpty()) {
            throw new ValidationException("Missing First Name");
        } else if (customer.getPersonalNumber().isEmpty()){
            throw new ValidationException("Missing Personal Number");
        }
    }
}
