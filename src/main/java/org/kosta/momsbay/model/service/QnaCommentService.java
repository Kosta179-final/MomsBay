package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.QnaCommentMapper;
import org.kosta.momsbay.model.vo.CommentVO;
import org.kosta.momsbay.model.vo.QnaCommentVO;
import org.springframework.stereotype.Service;
/**
 * 댓글 관련 비즈니스로직 서비스.
 * 관련Mapper: CommentMapper
 * @author Jung
 */
@Service
public class QnaCommentService {
	@Resource
	private QnaCommentMapper qnaCommentMapper;
	
	public List<CommentVO> getQnaCommentList(int bayPostNo){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("bayPostNo", bayPostNo);
		return qnaCommentMapper.getQnaCommentList(map);
	}
	public int addQnaComment(QnaCommentVO qnaCommentVO) {
		return qnaCommentMapper.addQnaComment(qnaCommentVO);
	}
	public int deleteComment(int bayCommentNo) {
		return qnaCommentMapper.deleteComment(bayCommentNo);
	}
	public int updateComment(QnaCommentVO qnaCommentVO) {
		return qnaCommentMapper.updateComment(qnaCommentVO);
	}
}
