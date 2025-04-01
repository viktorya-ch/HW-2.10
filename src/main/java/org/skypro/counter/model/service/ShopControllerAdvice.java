package org.skypro.counter.model.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException(NoSuchProductException s) {
        ShopError error = new ShopError(" 999 ", " Поиск не принес результатов ");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
