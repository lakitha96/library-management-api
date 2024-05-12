package com.example.librarymanagementapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * @author lakithaprabudh
 */
@ControllerAdvice
public class GeneralExceptionHandlerAdviceController {

    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    GeneralResponse handleBadRequest(CustomBadRequestException exception) {
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setLastModified(new Date());
        generalResponse.setMessage(exception.getMessage());
        generalResponse.setStatusInfo(HttpStatus.BAD_REQUEST);
        return generalResponse;
    }

    @ExceptionHandler(CustomInternalServerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    GeneralResponse handleInternalServerError(CustomInternalServerException exception) {
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setLastModified(new Date());
        generalResponse.setMessage(exception.getMessage());
        generalResponse.setStatusInfo(HttpStatus.INTERNAL_SERVER_ERROR);
        return generalResponse;
    }
}
