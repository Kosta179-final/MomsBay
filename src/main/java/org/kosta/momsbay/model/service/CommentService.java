package org.kosta.momsbay.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.BayCommentMapper;
import org.kosta.momsbay.model.vo.BayCommentVO;
import org.springframework.stereotype.Service;
/**
 * 댓글 관련 비즈니스로직 서비스.
 * 관련Mapper: CommentMapper
 * @author 개발제발
 */
@Service
public class CommentService {
	@Resource
	private BayCommentMapper bayCommentMapper;
	
	public List<BayCommentVO> getBayCommentList(int bayPostNo){
		return bayCommentMapper.getBayCommentList(bayPostNo);
	}
}
