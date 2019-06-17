package com.test.buttons.handler;

import com.test.buttons.exception.EntityNotFoundException;
import com.test.buttons.handler.error.ApiErrorConst;
import com.test.buttons.handler.error.RestError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestError processMaxDownloadException(EntityNotFoundException exception) {
        return new RestError(ApiErrorConst.ERR_GAME_NOT_FOUND, exception.getMessage(),
                HttpStatus.NOT_FOUND.value());
    }
}