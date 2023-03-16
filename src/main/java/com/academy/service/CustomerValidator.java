package com.academy.service;

import com.academy.entity.CountryCode;
import com.academy.entity.Customer;
import com.academy.exception.InvalidCountryCodeException;
import com.academy.exception.MandatoryValueMissingException;
import com.academy.service.CustomerAdultValidator;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {
    private ReusableValidator<Customer> adultValidator = new CustomerAdultValidator();
    private ReusableValidator<Customer> codeValidator = new CountryCodeValidator();
    private ReusableValidator<Customer> mandatoryValidator = new MandatoryCustomerValuesValidator();
    public void validate(Customer customer){
       mandatoryValidator.validate(customer);
       codeValidator.validate(customer);
       adultValidator.validate(customer);
    }
}
