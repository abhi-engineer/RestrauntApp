package com.app.exception;

import java.io.Serial;

public class MyAppException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public MyAppException(String msg){
        super(msg);
    }
}
