package org.arthur.ss6_jpa.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.arthur.ss6_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailValidator implements ConstraintValidator<ValidEmail,String> {
    @Autowired
    IStudentService studentService;
    long id;
    String email;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        this.id = constraintAnnotation.id();
        this.email = constraintAnnotation.email();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
//        return !studentService.existsByEmail(email) && id != 0;
        return true;
    }
}
