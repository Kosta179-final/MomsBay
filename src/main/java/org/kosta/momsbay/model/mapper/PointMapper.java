package org.kosta.momsbay.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * 포인트 충전, 환전 관련 기능 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface PointMapper {
	void updateChargePoint(String id, String point);
	void updateChargePoint(Map<String, String> map);
	void updateExchangePoint(Map<String, String> map);	
}
