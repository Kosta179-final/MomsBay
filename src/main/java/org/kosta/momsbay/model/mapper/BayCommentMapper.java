package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.BayCommentVO;
import org.kosta.momsbay.model.vo.CommentVO;
/**
 * 일반 게시판 DB연동 Mapper.
 * @author 개발제발
 */
@Mapper
public interface BayCommentMapper {
	public List<CommentVO> getBayCommentList(Map map);
	
	public int addComment(BayCommentVO bayCommentVO);
	
	public int updateComment(BayCommentVO bayCommentVO);
	
	public int deleteComment(int bayCommentNo);
}
