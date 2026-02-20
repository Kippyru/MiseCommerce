package com.kevin.microservices.producto_microservice.exceptions;

import com.kevin.microservices.common_exceptions.ErrorResponse;
import com.kevin.microservices.common_exceptions.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice(basePackages = "com.kevin.microservices.producto_microservice")
@Primary
@Slf4j
public class ProductoExceptionHandler extends GlobalExceptionHandler {
    @ExceptionHandler(CategoriaException.class)
    public ResponseEntity<ErrorResponse> handle (CategoriaException exception) {
        var errors = new HashMap<String, String>();
        var fieldName = "producto-service";
        errors.put(fieldName, exception.getMessage());
        log.warn("Error en categoria: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }

    @ExceptionHandler(ProductoException.class)
    public ResponseEntity<ErrorResponse> handle (ProductoException exception) {
        var errors = new HashMap<String, String>();
        var fieldName = "producto-service";
        errors.put(fieldName, exception.getMessage());
        log.warn("Error en Producto: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}