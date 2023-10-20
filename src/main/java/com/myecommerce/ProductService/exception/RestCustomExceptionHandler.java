package com.myecommerce.ProductService.exception;

import com.myecommerce.ProductService.model.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestCustomExceptionHandler {

    @ExceptionHandler(ProductCustomException.class)
    ResponseEntity<CustomException> RestCustomExceptionHandler(ProductCustomException exception){

        return new ResponseEntity<>(
                new CustomException().builder()
                        .errorMessage(exception.getMessage())
                        .errorCode(exception.getErrorCode())
                        .build(), HttpStatus.NOT_FOUND );
    }
}
