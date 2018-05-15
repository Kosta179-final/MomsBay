package org.kosta.momsbay.model.service;

import java.util.List;

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
	/**
	 * id로 조회한 포인트 내역 반환.
	 * @param id
	 * @return 포인트 내역 리스트
	 */
	public List<PointHistoryVO> getPointHistoryById(String id) {
		List<PointHistoryVO> pointHistory=pointHistoryMapper.getPointHistoryById(id);
		return pointHistory;
	}

}
