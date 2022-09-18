package com.geektrust.courseschedule.exception;

public class InvalidCourseCancelRequestException extends RuntimeException{
    private final String message;

    public InvalidCourseCancelRequestException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
