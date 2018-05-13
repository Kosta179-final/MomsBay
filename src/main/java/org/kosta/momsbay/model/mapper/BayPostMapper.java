package org.kosta.momsbay.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.kosta.momsbay.model.vo.PostVO;
/**
 * 일반 게시판 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface BayPostMapper {
	public List<PostVO> getBayPostList(PagingBean pagingBean);
	
	public int getTotalPostCount();
	
	public void addPost(BayPostVO bayPostVO);
}
