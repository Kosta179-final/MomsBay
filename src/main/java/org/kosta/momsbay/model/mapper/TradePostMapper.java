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
	 * @param Map<String,Object>
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
	 * 게시판종류와 카테고리에 맞게 게시글 총 수를 반환해주는 메서드.
	 * @param map
	 * @return int
	 * @author Jung
	 */
	public int getTotalTradePostCount(Map map);

	/**
	 * 게시물번호로 해당 게시물의 상세내용을 반환해주는 메서드.
	 * @param tradePostNo
	 * @return TradePostVO
	 * @author Jung
	 */
	public TradePostVO findTradePostByTradePostNo(int tradePostNo);
	
	/**
	 * 게시물번호로 해당 게시물을 삭제하는 메서드.
	 * @param tradePostNO
	 * @author Jung
	 */
	public void deleteTradePost(int tradePostNo);
	
}










