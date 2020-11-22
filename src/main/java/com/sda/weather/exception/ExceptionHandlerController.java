package com.sda.weather.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Log4j2
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BadCreationParametersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void badCreationParameterHandler(BadCreationParametersException exception) {
        log.error(exception.getMessage());
    }

    @ExceptionHandler(LocalisationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void localosationNotFoundHandler(LocalisationNotFoundException exception){
        log.error(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    void runetimeHandler(RuntimeException exception){
        log.error("Because of " + exception.getMessage() + " I don't know, what to do. So I turned into a TEAPOT ¯\\_(ツ)_/¯");
    }
}
