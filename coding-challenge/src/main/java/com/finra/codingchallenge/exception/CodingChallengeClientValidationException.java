package com.finra.codingchallenge.exception;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public class CodingChallengeClientValidationException extends RuntimeException{

	private static final long serialVersionUID = 1290700318513552325L;

	public CodingChallengeClientValidationException(String message, Throwable t) {
        super(message, t);
    }

    public CodingChallengeClientValidationException(String message) {
        super(message);
    }
}