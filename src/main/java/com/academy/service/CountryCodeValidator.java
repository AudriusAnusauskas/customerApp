package com.academy.service;

import com.academy.entity.CountryCode;
import com.academy.entity.Customer;
import com.academy.exception.InvalidCountryCodeException;
import com.academy.exception.ValidationException;

public class CountryCodeValidator extends ReusableValidator<Customer> {

    @Override
    public void validate(Customer customer) {
        if (!customer.getCountryCode().isEmpty()){
            try {
                CountryCode.valueOf(customer.getCountryCode().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new ValidationException("Country code is invalid");
            }

        }
    }
}
