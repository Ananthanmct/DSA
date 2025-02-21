package com.central.zepto.central_api.exception;

public class ProductNotPresentException extends RuntimeException{
    public ProductNotPresentException(String message){
        super(message);
    }
}
