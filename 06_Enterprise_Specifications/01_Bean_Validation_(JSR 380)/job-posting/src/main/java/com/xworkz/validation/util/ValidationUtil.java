package com.xworkz.validation.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * A Generic Utility to validate any DTO annotated with JSR 380 constraints.
 * @param <T> The type of the DTO being validated.
 */
public class ValidationUtil<T> {

    public boolean validate(T dto) {
        // 1. Initialize the Validation Engine (Hibernate Validator is the common implementation)
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // 2. Perform validation and capture any constraint violations
        // This Set will contain an entry for every annotation (like @NotBlank) that fails
        Set<ConstraintViolation<T>> violations = validator.validate(dto);

        // 3. Process the results
        if(!violations.isEmpty()) {
            System.err.println("--- Validation Audit: FAILED ---");
            System.err.println("Entity: " + dto.getClass().getSimpleName());

            // Print each specific error message defined in your DTO
            violations.forEach(v -> System.err.println("Error Field [" + v.getPropertyPath() + "]: " + v.getMessage()));

            return false; // Stop the process here
        }

        System.out.println("--- Validation Audit: SUCCESS ---");
        System.out.println("Entity: " + dto.getClass().getSimpleName() + " is clean and ready for DB/Service layer.");
        return true;
    }
}