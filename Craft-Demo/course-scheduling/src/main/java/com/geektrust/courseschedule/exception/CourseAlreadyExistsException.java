package com.geektrust.courseschedule.exception;

public class CourseAlreadyExistsException extends RuntimeException{
    private final String message;

    public CourseAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
