package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.BayCommentMapper;
import org.kosta.momsbay.model.mapper.TradeCommentMapper;
import org.kosta.momsbay.model.vo.BayCommentVO;
import org.kosta.momsbay.model.vo.CommentVO;
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
	@Resource
	private BayCommentMapper bayCommentMapper;
	
	public List<TradeCommentVO> getTradeCommentList(int tradePostNo){
		return tradeCommentMapper.getTradeCommentList(tradePostNo);
	}
	
	public List<CommentVO> getBayCommentList(int bayPostNo) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("bayPostNo",bayPostNo);
		return bayCommentMapper.getBayCommentList(map);
	}
	
	public int addComment(BayCommentVO bayCommentVO) {
		return bayCommentMapper.addComment(bayCommentVO);
	}
	
	public int updateComment(BayCommentVO bayCommentVO) {
		return bayCommentMapper.updateComment(bayCommentVO);
	}
	
	public int deleteComment(int bayCommentNo) {
		return bayCommentMapper.deleteComment(bayCommentNo);
	}
}
