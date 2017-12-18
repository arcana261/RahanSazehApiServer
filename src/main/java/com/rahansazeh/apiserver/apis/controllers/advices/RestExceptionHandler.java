package com.rahansazeh.apiserver.apis.controllers.advices;

import com.rahansazeh.apiserver.controller.error.NotFoundException;
import com.rahansazeh.apiserver.apis.controllers.wrappers.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestController
public class RestExceptionHandler /*extends ResponseEntityExceptionHandler*/ {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseWrapper handleNotFound(NotFoundException error) {
        return ResponseWrapper.error(error);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseWrapper handleValidationFailure(MethodArgumentNotValidException error) {
        return ResponseWrapper.error(error);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseWrapper handleInternalServerError(Exception error) {
        return ResponseWrapper.error(error);
    }
}
