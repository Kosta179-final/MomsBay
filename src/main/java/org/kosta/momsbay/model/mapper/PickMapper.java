package org.kosta.momsbay.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.TradePostVO;
/**
 * 찜 관련 기능 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface PickMapper {
	/**
	 * 아이디로 찜목록을 가져오는 메서드.
	 * @param id
	 * @return List<TradePostVO>
	 * @author Jung
	 */
	public List<TradePostVO> findPickListById(String id);
}
