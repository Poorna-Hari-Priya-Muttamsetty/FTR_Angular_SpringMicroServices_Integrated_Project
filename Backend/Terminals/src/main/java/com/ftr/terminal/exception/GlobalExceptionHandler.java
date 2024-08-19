package com.ftr.terminal.exception;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ftr.terminal.util.TerminalConstants;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception{
	private static final long serialVersionUID = 1L;

    @Autowired
    private Environment environment;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception e) {
        ErrorMessage error = new ErrorMessage();
        error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(environment.getProperty(TerminalConstants.TERMINAL_GENERAL_EXCEPTION.toString()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        ErrorMessage error = new ErrorMessage();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" , ")));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessage> constraintViolationExceptionHandler(ConstraintViolationException e){
        ErrorMessage error = new ErrorMessage();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(" , ")));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TerminalException.class)
    public ResponseEntity<ErrorMessage> userNotFoundExceptionhandler(TerminalException e){
        ErrorMessage error = new ErrorMessage();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(environment.getProperty(e.getMessage()));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
