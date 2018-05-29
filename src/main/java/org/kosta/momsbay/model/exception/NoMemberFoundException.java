package org.kosta.momsbay.model.exception;

public class NoMemberFoundException extends Exception{

	/**
	 * 비밀번호 찾기를 실행한 후 일치하는 멤버가 없을 경우 exception 발생
	 */
	private static final long serialVersionUID = 8092038668931809806L;
	public NoMemberFoundException(String message) {
		super(message);
	}	
}
