package com.example.demo.gomes.spring_app.infra;

import com.example.demo.gomes.spring_app.exceptions.BadRequest;
import com.example.demo.gomes.spring_app.exceptions.NotFound;
import com.example.demo.gomes.spring_app.models.ExceptionModel;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{


    @ExceptionHandler(BadRequest.class)
    public final ResponseEntity<ExceptionModel> handleBadRequestException(Exception ex, WebRequest request) {

        ExceptionModel exceptionModel = new ExceptionModel(ex.getMessage(), request.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<>(exceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFound.class)
    public final ResponseEntity<ExceptionModel> handleNotFoundException(Exception ex, WebRequest request) {

        ExceptionModel exceptionModel = new ExceptionModel(ex.getMessage(), request.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<>(exceptionModel, HttpStatus.NOT_FOUND);
    }

}