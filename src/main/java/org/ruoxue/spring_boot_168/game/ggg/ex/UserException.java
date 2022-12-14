package org.ruoxue.spring_boot_168.game.ggg.ex;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 257390917818772971L;

	public UserException() {
		super();
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

}
