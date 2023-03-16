package com.academy.service;

import org.springframework.stereotype.Service;

@Service
public abstract class ReusableValidator<T> {
    public abstract void validate(T attribute);
}
