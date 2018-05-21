package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.BayPostMapper;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.springframework.stereotype.Service;
/**
 * 일반게시판 관련 비즈니스로직 서비스.
 * 관련Mapper: BayPostMapper
 * @author Hwang
 */
@Service
public class BayPostService {
	@Resource
	private BayPostMapper bayPostMapper;	
	
	public ListVO getBayPostList(String pageNo, String boardTypeNo, String searchWord) {
		Map<String,Object> map = new HashMap();
		map.put("boardTypeNo", Integer.parseInt(boardTypeNo));
		map.put("searchWord", searchWord);
		int totalCount=bayPostMapper.getTotalPostCount(map);
		PagingBean pagingBean=null;
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(9);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(9);
		}
		map.put("pagingBean", pagingBean);
		return new ListVO(bayPostMapper.getBayPostList(map),pagingBean);
	}
	
	public ListVO getAnnounceList(String pageNo, String boardTypeNo, String searchWord) {
		Map<String,Object> map = new HashMap();
		map.put("boardTypeNo", boardTypeNo);
		map.put("searchWord", searchWord);
		int totalCount=bayPostMapper.getTotalPostCount(map);
		PagingBean pagingBean=null;
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(9);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(9);
		}
		map.put("pagingBean", pagingBean);
		return new ListVO(bayPostMapper.getAnnounceList(map),pagingBean);
	}
	
	public void addPost(BayPostVO bayPostVO) {
		bayPostMapper.addPost(bayPostVO);
	}
	
	public BayPostVO getPostDetail(int bayPostNo) {
		return bayPostMapper.getPostDetail(bayPostNo);
	}
	
	public void deletePost(int bayPostNo) {
		bayPostMapper.deletePost(bayPostNo);
	}
	
	public void updatePost(BayPostVO bayPostVO) {
		bayPostMapper.updatePost(bayPostVO);
	}
}
