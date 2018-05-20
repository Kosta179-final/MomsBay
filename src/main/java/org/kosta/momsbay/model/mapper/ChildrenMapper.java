package org.kosta.momsbay.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.ChildrenStatisticsVO;
/**
 * member 관련 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface ChildrenMapper {
	public void addChildren(Map<String, String> tempMap);
	public ChildrenStatisticsVO getChildrenAgeStatistics(int i);
}
