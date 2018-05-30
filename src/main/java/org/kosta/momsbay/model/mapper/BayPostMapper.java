package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.kosta.momsbay.model.vo.PostVO;
/**
 * 일반 게시판 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface BayPostMapper {
	public List<PostVO> getBayPostList(Map map);
	
	public int getTotalPostCount(Map map);
	
	public void addPost(BayPostVO bayPostVO);
	
	public BayPostVO getPostDetail(int bayPostNo);
	
	public void deletePost(int bayPostNo);
	
	public void updatePost(BayPostVO bayPostVO);
	
	public List<PostVO> getAnnounceList(Map map);
	
	public void updatePostCount(int bayPostNo);
}
