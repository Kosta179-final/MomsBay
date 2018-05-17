package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.mapper.PointHistoryMapper;
import org.kosta.momsbay.model.vo.PointHistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 포인트와 거래내역 처리 비즈니스로직 서비스.
 * 관련Mapper: PointHistoryMapper, TradeHistoryMapper
 * @author Hwang
 */
@Service
public class HistoryService {
	@Autowired
	PointHistoryMapper pointHistoryMapper;
	@Autowired
	MemberMapper memberMapper;
	
	/**
	 * id로 조회한 포인트 내역 반환.
	 * @param id
	 * @return 포인트 내역 리스트
	 */
	public List<PointHistoryVO> getPointHistoryById(String id) {
		List<PointHistoryVO> pointHistory=pointHistoryMapper.getPointHistoryById(id);
		return pointHistory;
	}
	
	/**
	 * 포인트 내역을 남기는 서비스를 제공.
	 * 현재 포인트도 id로 찾아서 남긴다.
	 * @param id
	 * @param point
	 */
	public void addPointChargeHistory(String id, String point) {
		Map<String, String> map = new HashMap<String, String>();
		String nPoint = memberMapper.findNowpointById(id);
		map.put("id", id);
		map.put("point", point);
		map.put("nowPoint", nPoint);
		pointHistoryMapper.addPointChargeHistory(map);
	}

	public void addPointExchangeHistory(String id, String exchangePoint) {
		Map<String, String> map = new HashMap<String, String>();
		String nPoint = memberMapper.findNowpointById(id);
		map.put("id", id);
		map.put("point", exchangePoint);
		map.put("nowPoint", nPoint);
		pointHistoryMapper.addPointExchangeHistory(map);
	}

}
