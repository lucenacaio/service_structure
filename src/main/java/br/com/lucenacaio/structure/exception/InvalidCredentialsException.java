package br.com.lucenacaio.structure.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String message){
        super(message);
    }

    public InvalidCredentialsException(String message, Throwable e){
        super(message, e);
    }

}
