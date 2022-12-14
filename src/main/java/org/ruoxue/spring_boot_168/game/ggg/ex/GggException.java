package org.ruoxue.spring_boot_168.game.ggg.ex;

public class GggException extends RuntimeException {

	private static final long serialVersionUID = 2209749235554430258L;

	public GggException() {
		super();
	}

	public GggException(String message) {
		super(message);
	}

	public GggException(Throwable cause) {
		super(cause);
	}

	public GggException(String message, Throwable cause) {
		super(message, cause);
	}

}
