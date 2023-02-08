package br.com.lucenacaio.structure.exception.handler;

import br.com.lucenacaio.structure.exception.CategoryNotFoundException;
import br.com.lucenacaio.structure.exception.InvalidCredentialsException;
import br.com.lucenacaio.structure.exception.InvalidTokenSignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = { CategoryNotFoundException.class })
    public ResponseEntity<String> notFoundConstrainHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = { InvalidTokenSignatureException.class, InvalidCredentialsException.class })
    public ResponseEntity<String> authExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ex.getLocalizedMessage());
    }


}
