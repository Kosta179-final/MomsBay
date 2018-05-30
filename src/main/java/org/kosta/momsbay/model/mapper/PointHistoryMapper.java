package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * 포인트 관련 처리 DB연동 Mapper.
 * 관련VO: PointHistoryVO
 * @author Hwang
 */
@Mapper
public interface PointHistoryMapper {
	void addPointChargeHistory(Map<String, Object> map);
	void addPointExchangeHistory(Map<String, Object> map);
	void addPointSellHistory(Map<String, Object> map);
	void addPointBuyHistory(Map<String, Object> map);
	int getTotalPointHistoryById(String id);
	List<Object> getPointHistoryById(Map<String, Object> map);
	int getTotalPointHistoryByIdAndDate(Map<String, Object> map);
	List<Object> getPointHistoryByIdAndDate(Map<String, Object> map);	
}
