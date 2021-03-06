package com.gro.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.gro.model.ApiError;
import com.gro.model.notification.NotificationNotFoundException;
import com.gro.model.relay.InvalidRelayStateException;
import com.gro.model.rpicomponent.InvalidRPiComponentTypeException;
import com.gro.model.rpicomponent.RPiComponentNotFoundException;

@ControllerAdvice
@RestController
public class GlobalControllerExceptionHandler {
    
    @ExceptionHandler(RPiComponentNotFoundException.class)
    public ResponseEntity<Object> handleRPiComponentNotFound(RPiComponentNotFoundException e, WebRequest request) {
        String error = e.getMessage();
        ApiError apiError = 
                new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), error);
        
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
    
    @ExceptionHandler(InvalidRPiComponentTypeException.class)
    public ResponseEntity<Object> handleInvalidRPiComponentType(InvalidRPiComponentTypeException e, WebRequest request) {
        String error = e.getMessage();
        ApiError apiError = 
                new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, e.getLocalizedMessage(), error);
        
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
    
    @ExceptionHandler(InvalidRelayStateException.class)
    public ResponseEntity<Object> handleInvalidRelayState(InvalidRelayStateException e, WebRequest request) {
        String error = e.getMessage();
        ApiError apiError = 
                new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, e.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
    
    @ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<Object> handleNotificationNotFoundException(NotificationNotFoundException e, WebRequest request) {
        String error = e.getMessage();
        ApiError apiError =
                new ApiError(HttpStatus.NOT_FOUND, e.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
    
}
