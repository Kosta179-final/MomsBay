package org.kosta.momsbay.model.exception;

/**
 * 로그인 Exception을 처리하기 위한 별도의 클래스.
 * @author Hwang
 */
public class LoginException extends Exception {
	private static final long serialVersionUID = -7723102321389707462L;
	public LoginException(String message) {
		super(message);
	}
}
