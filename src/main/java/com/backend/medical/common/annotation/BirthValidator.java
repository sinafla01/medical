package com.backend.medical.common.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BirthValidator implements ConstraintValidator<Birth, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("\\d{4}=\\d{2}-\\{2}");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
