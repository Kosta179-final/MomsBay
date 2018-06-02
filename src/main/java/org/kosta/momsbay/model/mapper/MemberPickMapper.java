package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.PostVO;
import org.kosta.momsbay.model.vo.TradePostVO;
/**
 * 찜 목록 추가, 삭제 기능 DB연동 Mapper.
 * @author 개발제발
 */
@Mapper
public interface MemberPickMapper {
	public void deleteMemberPick(TradePostVO tradePostVO);

	public void addMemberPick(TradePostVO tradePostVO);
	
	/**
	 * 아이디로 페이징 처리된 찜목록을 가져오는 메서드.
	 * @param id
	 * @return List<TradePostVO>
	 * @author Jung
	 */
	@SuppressWarnings("rawtypes")
	public List<PostVO> findPickListById(Map map);
	
	/**
	 * trade_post_no가 찜 목록에 있는지 확인하는 메서드
	 * @param tradePostVO
	 * @return 찜 목록에 있으면 true, 없으면 false
	 * @author Jung
	 */
	public boolean isPickTradePost(TradePostVO tradePostVO);
	
	/**
	 * 찜 수를 업데이트 하는 메서드
	 * @param map
	 * @author Jung
	 */
	@SuppressWarnings("rawtypes")
	public void updatePickCount(Map map);

	/**
	 * 해당 id의 찜 목록 갯수 반환
	 * @param id
	 * @return int
	 * @author Jung
	 */
	public int findTotalPickCountById(String id);

	/**
	 * 아이디로 전체 찜목록을 가져오는 메서드.
	 * @param id
	 * @return List<TradePostVO>
	 * @author Jung
	 */
	public List<TradePostVO> findAllPickListById(String id);
}
