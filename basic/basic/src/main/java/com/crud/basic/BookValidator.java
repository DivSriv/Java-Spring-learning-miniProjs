package com.crud.basic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class BookValidator implements ConstraintValidator<BookValidation, String> {


    public boolean isValid(String bookName, ConstraintValidatorContext cxt) {
        List<String> list = Arrays.asList("A","B","C");
        return list.contains(bookName);
    }
}
