package com.sda.weather.exception;

public class LocalisationNotFoundException extends RuntimeException {

    private final static String MESSAGE = "Localisation with %s id not found";

    public LocalisationNotFoundException(Long id) {
        super(String.format(MESSAGE, id));
    }
}
