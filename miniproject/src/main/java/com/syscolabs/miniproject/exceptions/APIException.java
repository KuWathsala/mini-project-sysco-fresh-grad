package com.syscolabs.miniproject.exceptions;

public class APIException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    APIException(String message){
        super(message);
    }

}
