package com.academy.service;

import com.academy.entity.Customer;
import com.academy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
@Autowired
private Validator validator;

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    private String capitalizeFirstLetter( String word){
        if(!word.isEmpty()){
            return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        }
        else return word;
    }

    private String formattedNumber(String number){
        if(!number.isEmpty()){
            return number.substring(0,4) + '-' + number.substring(4);
        } else {
            return number;
        }
    };


    public void insertCustomer( Customer customer) {

        validator.validate(customer);

        Customer customer1 = new Customer.Builder(capitalizeFirstLetter(customer.getFirstName()),
                capitalizeFirstLetter(customer.getLastName()),
                formattedNumber(customer.getPersonalNumber()))
                .withMiddleName(customer.getMiddleName())
                .withAge(customer.getAge())
                .withCountryCode(customer.getCountryCode())
                        .build();


        customerRepository.insert(customer1);
    }



    public void deleteCustomer( String customerId) {
        customerRepository.deleteById(customerId);
    }
}
