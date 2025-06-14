package br.com.fiap.exception;

public class ContaDaoException extends Exception {

    public ContaDaoException(String message){
        super(message);
    }

    public ContaDaoException(String message, Throwable cause){
        super(message, cause);
    }

}
