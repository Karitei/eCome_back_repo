package com.hs.e.Com.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message){
        super(message);
    }
}
