package org.kosta.momsbay.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.PointHistoryVO;
/**
 * 포인트 관련 처리 DB연동 Mapper.
 * 관련VO: PointHistoryVO
 * @author Hwang
 */
@Mapper
public interface PointHistoryMapper {
	List<PointHistoryVO> getPointHistoryById(String id);	
}
