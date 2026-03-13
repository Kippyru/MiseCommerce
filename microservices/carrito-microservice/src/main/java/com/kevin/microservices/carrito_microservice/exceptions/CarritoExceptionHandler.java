package com.kevin.microservices.carrito_microservice.exceptions;

import com.kevin.microservices.common_exceptions.ErrorResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice(basePackages = "com.kevin.microservices.carrito_microservice")
@Primary
@Slf4j
public class CarritoExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(FeignException exception) {
        var errors = new HashMap<String, String>();
        var fieldName = "Error comunicandose con el microservice";
        errors.put(fieldName, exception.getMessage());
        log.warn("Error comunicandose con el microservice: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }

    @ExceptionHandler(CarritoException.class)
    public ResponseEntity<ErrorResponse> handle (CarritoException ce)
    {
        var errors = new HashMap<String, String>();
        var fieldName = "carrito";
        errors.put(fieldName, ce.getMessage());
        log.warn("Carrito error: {}", ce.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
