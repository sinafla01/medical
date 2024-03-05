package com.backend.medical.common.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {BirthValidator.class})
@Documented
public @interface Birth {
    String message() default "생년월일이 올바르지 않습니다.";

    Class<?>[] groups() default  {};

    Class<? extends Payload>[] payload() default {};
}
