package org.ruoxue.spring_boot_168.sso.account.ex;

public class AccountException extends RuntimeException {

	private static final long serialVersionUID = 1759876856800045047L;

	public AccountException() {
		super();
	}

	public AccountException(String message) {
		super(message);
	}

	public AccountException(Throwable cause) {
		super(cause);
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
	}
}
