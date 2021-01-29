package com.sino.exep;

public class NotEnoughException extends RuntimeException{
    //自定义异常类

    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
