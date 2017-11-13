package com.finra.codingchallenge.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.finra.codingchallenge.utils.Constants;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@ControllerAdvice
public class CodingChallengeExceptionHandler{
	
    private Logger logger = LoggerFactory.getLogger(CodingChallengeExceptionHandler.class);
    
    @ExceptionHandler(CodingChallengeServiceException.class)
    public String handleServiceException(Exception ex, WebRequest request) {
        logger.error("Handling Exception: {}", ex);
        return Constants.REDIRECT + Constants.UAS_SERVICE_ERROR;
    }
    
    @ExceptionHandler(CodingChallengeClientValidationException.class)
    public String handleClientValidationException(CodingChallengeClientValidationException ex, WebRequest request) {
        logger.error("Handling Exception: {}", ex);
        // For now both the methods return to the same error page, but in future, we can add different pages for different errors.
        return Constants.REDIRECT + Constants.UAS_CLIENT_ERROR;
    }
}