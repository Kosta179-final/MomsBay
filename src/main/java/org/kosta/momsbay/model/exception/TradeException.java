package org.kosta.momsbay.model.exception;

/**
 * 거래 Exception을 처리하기 위한 별도의 클래스.
 * @author Jung
 */
public class TradeException extends Exception {
	private static final long serialVersionUID = -7723102321389707462L;
	public TradeException(String message) {
		super(message);
	}
}
