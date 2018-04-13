package com.example.alexis.projeteuropcar.Service;

/**
 * Created by Administrateur on 13/04/2018.
 */

public class APIException extends Throwable {
    private String message;
    private int code;

    public APIException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
