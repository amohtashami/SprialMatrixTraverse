package io.github.amohtashami.exception;

/**
 * When a user try to get an undefined row/column index on a matrix this exception is thrown
 * @Author alieh on 9/19/22
 */
public class WrongIndexException extends RuntimeException {

	public WrongIndexException(String message) {
		super(message);
	}
}
