package com.Emazon.stock_mircoservice.Infrastructure.exceptionHandler;

import com.Emazon.stock_mircoservice.Infrastructure.exceptionHandler.exception.CategoryAlreadyExistsException;
import com.Emazon.stock_mircoservice.Infrastructure.exceptionHandler.exception.ElementNotFoundException;
import com.Emazon.stock_mircoservice.domine.exception.EmptyFieldException;

import com.Emazon.stock_mircoservice.domine.exception.InvalidLengthMaxDescription;
import com.Emazon.stock_mircoservice.domine.exception.InvalidLengthMaxName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler (EmptyFieldException.class)
    public ResponseEntity<ResponseException> handleEmptyFieldException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseException(
                    ExceptionConstans.EMPTY_FILE,
                    HttpStatus.BAD_REQUEST.toString(),
                    LocalDateTime.now()
        )  );
    }

    @ExceptionHandler (InvalidLengthMaxName.class)
    public ResponseEntity<ResponseException> handleInvalidLengthMaxNameException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseException(
                    ExceptionConstans.INVALID_LENGTH_NAME,
                    HttpStatus.BAD_REQUEST.toString(),
                    LocalDateTime.now()
        ));
    }

    @ExceptionHandler (InvalidLengthMaxDescription.class)
    public ResponseEntity<ResponseException> handleInvalidLengthMaxDescriptionException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseException(
                    ExceptionConstans.INVALID_LENGTH_DESCRIPTION,
                    HttpStatus.BAD_REQUEST.toString(),
                    LocalDateTime.now()
        ));
    }

    @ExceptionHandler (CategoryAlreadyExistsException.class)
    public  ResponseEntity<ResponseException> handleCategoryAlreadyExistsException(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ResponseException(
                    ExceptionConstans.CATEGORY_ALREADY_EXISTS,
                    HttpStatus.CONFLICT.toString(),
                    LocalDateTime.now()
        ));
    }

    @ExceptionHandler (ElementNotFoundException.class)
    public  ResponseEntity<ResponseException> handleElementNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseException(
                        ExceptionConstans.ELEMENT_NOT_FOUND,
                        HttpStatus.NOT_FOUND.toString(),
                        LocalDateTime.now()
                )
        );
    }

}
