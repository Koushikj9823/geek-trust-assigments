package com.geektrust.courseschedule.exception;

public class CourseCancelledException extends RuntimeException{
    private final String message;

    public CourseCancelledException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
