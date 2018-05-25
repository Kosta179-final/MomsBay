package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.exception.TradeException;
import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.mapper.PointMapper;
import org.kosta.momsbay.model.mapper.TradePostMapper;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 구매, 판매 관련 작업 서비스 제공.
 * 관련Mapper: TradeMapper, PointHistoryMapper, TradePostMapper
 * @author Hwang
 */
@Service
public class TradeService {
	@Resource
	private TradePostMapper tradePostMapper;
	@Resource
	private MemberMapper memberMapper;
	@Autowired
	PointMapper pointMapper;
	
	/**
	 * 거래신청시 구매자의 포인트를 차감.
	 * 포인트 부족시 Exception 발생.
	 * @param tradePostVO
	 * @throws TradeException
	 * @author Jung
	 */
	public void applyTransaction(TradePostVO tradePostVO) throws TradeException {
		int price=tradePostMapper.findPirceByTradePostNo(tradePostVO.getTradePostNo());
		int money= memberMapper.findNowpointById(tradePostVO.getTradeId());
		if(price>money) {
			throw new TradeException("포인트가 부족합니다");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",tradePostVO.getTradeId());
		map.put("point", -price);
		pointMapper.updateChargePoint(map);
	}
	
	
	/**
	 * 거래취소시 구매자에게 금액반환.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void cancelTransaction(TradePostVO tradePostVO) {
		int price=tradePostMapper.findPirceByTradePostNo(tradePostVO.getTradePostNo());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",tradePostVO.getTradeId());
		map.put("point", price);
		pointMapper.updateChargePoint(map);
	}
	
	/**
	 * 거래 완료시 판매자에게 입금.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void completeTransaction(TradePostVO tradePostVO) {
		int price=tradePostMapper.findPirceByTradePostNo(tradePostVO.getTradePostNo());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",tradePostVO.getMemberVO().getId());
		map.put("point", price);
		pointMapper.updateChargePoint(map);
	}
	
	
}
