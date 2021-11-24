package org.maktab.hibernate.exception;

public class DataNotFoundException extends Exception{
    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
