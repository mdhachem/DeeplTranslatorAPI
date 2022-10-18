package com.mdhachem.exception;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class TranslatorException extends RuntimeException {

	private static final long serialVersionUID = 7205284292199075256L;

	public TranslatorException(String message) {
		super(message);
	}

	public TranslatorException(String message, Throwable cause) {
		super(message, cause);
	}
}