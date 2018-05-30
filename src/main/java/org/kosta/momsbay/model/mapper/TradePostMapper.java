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
	@SuppressWarnings("rawtypes")
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
	@SuppressWarnings("rawtypes")
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

	/**
	 * 게시물번호로 해당 게시물을 수정하는 메서드.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateTradePost(TradePostVO tradePostVO);
	
	/**
	 * 거래 신청 시 게시물의 거래자에 id를 업데이트 하고 거래상태를 변경하는 메서드.
	 * @param id
	 * @author Jung
	 */
	public void updateTradeId(TradePostVO tradePostVO);
	
	/**
	 * 거래 취소 시 게시물의 거래자에 id를 NULL로 업데이트 하는 메서드.
	 * @param id
	 * @author Jung
	 */
	public void deleteTradeId(int tradePostNo);
	
	/**
	 * 게시물의 가격을 조회하는 메서드
	 * @param tradePostNo
	 * @return price
	 * @author Jung
	 */
	public int findPirceByTradePostNo(int tradePostNo);
	
	/**
	 * 삽니다 게시판 판매 신청시 tradeId와 suggestContent를 업데이트.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateTradeIdAndSuggestContent(TradePostVO tradePostVO);
	
	/**
	 * 홈화면 삽니다 팝니다 게시글 최신순 리스트
	 * @return List
	 * @author rws
	 */
	public List<PostVO> getMainTradePostList();
	
	/**
	 * 삽니다 팝니다 총 개시글수
	 * @return int
	 * @author rws
	 */
	public int getTotalMainTradePostCount();
}







