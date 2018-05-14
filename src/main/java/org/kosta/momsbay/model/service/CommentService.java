package org.kosta.momsbay.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.TradeCommentMapper;
import org.kosta.momsbay.model.vo.TradeCommentVO;
import org.springframework.stereotype.Service;
/**
 * 댓글 관련 비즈니스로직 서비스.
 * 관련Mapper: CommentMapper
 * @author Jung
 */
@Service
public class CommentService {
	@Resource
	private TradeCommentMapper tradeCommentMapper;
	
	public List<TradeCommentVO> getTradeCommentList(int tradePostNo){
		return tradeCommentMapper.getTradeCommentList(tradePostNo);
	}
}
