package com.geektrust.courseschedule.exception;

public class InputDataErrorException extends Exception{
    private final String message;

    public InputDataErrorException(String message,Throwable throwable){
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
