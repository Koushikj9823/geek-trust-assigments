package com.geektrust.courseschedule.exception;

public class CourseFullException extends RuntimeException{
    private final String message;

    public CourseFullException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
