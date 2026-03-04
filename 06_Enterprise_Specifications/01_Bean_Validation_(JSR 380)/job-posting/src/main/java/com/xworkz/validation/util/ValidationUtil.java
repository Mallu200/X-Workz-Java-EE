package com.xworkz.validation.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationUtil<T> {

    public boolean validate(T dto) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(dto);

        if(!violations.isEmpty()) {
            System.err.println("Validation failed for: " + dto.getClass().getSimpleName());
            violations.forEach(v -> System.err.println(">> " + v.getMessage()));
            return false;
            }

        System.out.println("Validation successful for: " + dto.getClass().getSimpleName());
        return true;
    }
}

