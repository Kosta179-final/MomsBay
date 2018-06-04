package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.CommentVO;
import org.kosta.momsbay.model.vo.QnaCommentVO;
/**
 * 일반 게시판 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface QnaCommentMapper {
	public List<CommentVO> getQnaCommentList(Map<String, Object> map);
	
	public int addQnaComment(QnaCommentVO qnaCommentVO);

	public int deleteComment(int bayCommentNo);
	
	public int updateComment(QnaCommentVO qnaCommentVO);
}
