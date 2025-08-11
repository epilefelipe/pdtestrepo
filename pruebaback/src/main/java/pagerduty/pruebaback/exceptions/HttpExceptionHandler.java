package pagerduty.pruebaback.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pagerduty.pruebaback.exceptions.errors.ApiError;

import java.util.Map;

@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(ApiError.class)
    public ResponseEntity<?> handleHttpException(ApiError ex){
        return ResponseEntity.status(ex.getStatus())
                .body(Map.of(
                        "success", false,
                        "message", ex.getMessage()
                ));
    }
}
