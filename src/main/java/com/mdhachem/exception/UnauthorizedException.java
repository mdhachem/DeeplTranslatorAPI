package com.mdhachem.exception;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 8450563529615015123L;

	public UnauthorizedException(String message) {
		super(message);
	}

	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}
}
