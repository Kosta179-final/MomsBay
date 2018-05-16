package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.Map;

import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.mapper.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 포인트 처리 관련 서비스.
 * ex)포인트 충전, 환전, 구매
 * 관련Mapper: PoingHistoryMapper
 * @author Hwang
 */
@Service
public class PointService {
	@Autowired
	PointMapper pointMapper;
	@Autowired
	MemberMapper memberMapper;
	
	/**
	 * 멤버 테이블에 포인트를 업데이트한다.
	 * @param id
	 * @param point
	 */
	public void updateChargePoint(String id, String point) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id",id);
		map.put("point", point);
		pointMapper.updateChargePoint(map);
	}
	
	/**
	 * 아이디로 현재 포인트를 조회한다.
	 * @param id
	 * @return 현재 포인트값
	 */
	public String findNowpointById(String id) {
		return memberMapper.findNowpointById(id);
	}
}
