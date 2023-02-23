package com.bms.globalexceptionhandlers.core.exceptions.handlers;

import com.bms.globalexceptionhandlers.core.exceptions.BusinessException;
import com.bms.globalexceptionhandlers.core.exceptions.NotFoundException;
import org.springframework.http.ProblemDetail;

public abstract class BaseExceptionHandler {
    protected abstract ProblemDetail handleException(BusinessException exception);
    protected abstract ProblemDetail handleException(NotFoundException exception);
    protected abstract ProblemDetail handleException(Exception exception);
}
