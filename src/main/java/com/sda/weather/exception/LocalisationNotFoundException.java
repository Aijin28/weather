package com.sda.weather.exception;

public class LocalisationNotFoundException extends RuntimeException {
public LocalisationNotFoundException(String message, Long id){
    super(message);
}
}
