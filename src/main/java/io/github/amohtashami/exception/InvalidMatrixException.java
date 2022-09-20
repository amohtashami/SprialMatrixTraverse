package io.github.amohtashami.exception;

/**
 * If user tries to create an invalid Matrix (empty, null, unbalanced number of columns in each row) this exception thrown
 * @Author alieh on 9/19/22
 */
public class InvalidMatrixException extends RuntimeException {

	public InvalidMatrixException(String message) {
		super(message);
	}
}
