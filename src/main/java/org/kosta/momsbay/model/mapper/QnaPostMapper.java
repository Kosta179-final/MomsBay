package org.kosta.momsbay.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.vo.PostVO;
/**
 * Q&A 게시판 DB연동 Mapper.
 * @author sam
 */
@Mapper
public interface QnaPostMapper {
	
	public List<PostVO> getQnaPostList(PagingBean pagingBean);
	
	public int getTotalPostCount();
}
