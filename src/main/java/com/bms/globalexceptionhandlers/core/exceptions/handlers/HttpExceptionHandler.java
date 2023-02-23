package com.bms.globalexceptionhandlers.core.exceptions.handlers;

import com.bms.globalexceptionhandlers.core.exceptions.BusinessException;
import com.bms.globalexceptionhandlers.core.exceptions.NotFoundException;
import com.bms.globalexceptionhandlers.core.exceptions.problemDetails.BusinessProblemDetails;
import com.bms.globalexceptionhandlers.core.exceptions.problemDetails.InternalServerProblemDetails;
import com.bms.globalexceptionhandlers.core.exceptions.problemDetails.NotFoundProblemDetails;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HttpExceptionHandler extends BaseExceptionHandler {
    @Override
    @ExceptionHandler(BusinessException.class)
    protected ProblemDetail handleException(BusinessException exception) {
        return new BusinessProblemDetails(exception.getMessage());
    }

    @Override
    @ExceptionHandler(NotFoundException.class)
    protected ProblemDetail handleException(NotFoundException exception) {
        return new NotFoundProblemDetails(exception.getMessage());
    }

    @Override
    @ExceptionHandler(Exception.class)
    protected ProblemDetail handleException(Exception exception) {
        return new InternalServerProblemDetails(exception.getMessage());
    }
}
