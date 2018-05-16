package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.PostVO;
import org.kosta.momsbay.model.vo.TradePostVO;

/**
 * 중고물품 게시판 관련 DB연동 Mapper.
 * 
 * @author Hwang
 */
@Mapper
public interface TradePostMapper {
	/**
	 * 페이징 처리된 거래게시판의 목록을 출력해주는 메서드.
	 * 
	 * @param pagingBean
	 * @return List<PostVO>
	 * @author Jung
	 */
	public List<PostVO> getTradePostList(Map map);

	/**
	 * 거래게시판에서 글을 작성할 때 실행되는 메서드.
	 * 
	 * @param tradePostVO
	 * @author Jung
	 */
	public void addTradePost(TradePostVO tradePostVO);

	/**
	 * 거래게시판의 총 게시물 숫자를 반환해주는 메서드
	 * 
	 * @return int
	 * @author Jung
	 */
	public int getTotalTradePostCount(Map map);

	public TradePostVO findTradePostByTradePostNo(int tradePostNo);
}
