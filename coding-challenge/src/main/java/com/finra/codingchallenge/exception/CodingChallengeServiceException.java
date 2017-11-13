package com.finra.codingchallenge.exception;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
public class CodingChallengeServiceException extends RuntimeException  {

	private static final long serialVersionUID = -7621291770581779888L;

	public CodingChallengeServiceException(String message) {
        super(message);
    }

    public CodingChallengeServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
