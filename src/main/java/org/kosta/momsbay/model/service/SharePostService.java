package org.kosta.momsbay.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.SharePostMapper;
import org.kosta.momsbay.model.vo.PostVO;
import org.kosta.momsbay.model.vo.SharePostVO;
import org.springframework.stereotype.Service;

/**
 * 교환게시판 관련 비즈니스로직 서비스.
 * 관련Mapper: SharePostMapper
 * @author Ryu
 */
@Service
public class SharePostService {
	 
	@Resource
	private SharePostMapper sharePostMapper;
	/**
	 * 나눔 게시판 글쓰기
	 * @param sharePostVO
	 */
	public void addSharePost(SharePostVO sharePostVO) {
		sharePostMapper.addSharePost(sharePostVO);
	}
	/**
	 * 나눔 게시판 리스트 목록
	 * @param pageNo
	 * @return 나눔 게시판 List
	 * @author rws
	 */
	public ListVO getSharePostList(String pageNo){
		int totalCount=sharePostMapper.getTotalSharePostCount();
		PagingBean pagingBean=null;
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
		}else {
			pagingBean=new PagingBean(totalCount, Integer.parseInt(pageNo));
		}
		List<PostVO> list=sharePostMapper.getSharePostList(pagingBean);
		ListVO listVO=new ListVO(list,pagingBean);
		return listVO;
	}
}
