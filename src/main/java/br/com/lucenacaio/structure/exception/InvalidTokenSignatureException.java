package br.com.lucenacaio.structure.exception;

public class InvalidTokenSignatureException extends RuntimeException{
    public InvalidTokenSignatureException(String message){
        super(message);
    }

}
