package org.kosta.momsbay.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.TradeCommentVO;
/**
 * 거래 게시판 관련 DB연동 Mapper.
 * @author 개발제발
 */
@Mapper
public interface TradeCommentMapper {
	/**
	 * 거래게시판 번호에 해당되는 댓글의 리스트를 가져온다
	 * @param tradePostNo
	 * @return List<TradeCommentVO>
	 * @author Jung
	 */
	public List<TradeCommentVO> getTradeCommentList(int tradePostNo);
}
