package org.arthur.ss6_jpa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class )
public @interface ValidEmail {
    String message() default "Email has been Exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    long id() default 0;
    String email() default "";
}
