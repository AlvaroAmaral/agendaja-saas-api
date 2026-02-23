package com.alvaro.agendaja.scheduling_api.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
