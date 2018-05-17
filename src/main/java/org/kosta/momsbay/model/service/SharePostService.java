package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.SharePostMapper;
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
	public ListVO getSharePostList(String pageNo, String boardTypeNo, String categoryNo){
		PagingBean pagingBean=null;
		Map<String, Object> map=new HashMap();
		map.put("board_type_no", Integer.parseInt(boardTypeNo));
		map.put("category_no", Integer.parseInt(categoryNo));
		int totalCount=sharePostMapper.getTotalSharePostCount(map);
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(9);
		}else {
			pagingBean=new PagingBean(totalCount, Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(9);
		}
		map.put("pagingBean", pagingBean);
		return new ListVO(sharePostMapper.getSharePostList(map),pagingBean);
	}
	
	/**
	 * 나눔게시글 상세보기
	 * @param noneTradePostNo
	 * @return SharePostVO
	 * @author rws
	 */
	public SharePostVO findDetailSharePost(int noneTradePostNo) {
		return sharePostMapper.findDetailSharePost(noneTradePostNo);
	}
	
	/**
	 * 나눔게시글 수정 화면
	 * @param noneTradePostNo
	 * @return SharePostVO
	 * @author rws
	 */
	public SharePostVO updateSharePostView(int noneTradePostNo) {
		return sharePostMapper.findDetailSharePost(noneTradePostNo);
	}
	
	/**
	 * 나눔게시글 수정
	 * @param sharePostVO
	 * @author rws
	 */
	public void updateSharePost(SharePostVO sharePostVO) {
		sharePostMapper.updateSharePost(sharePostVO);
	}
	
	/**
	 * 나눔게시글 삭제
	 * @param sharePostVO
	 * @author rws
	 */
	public SharePostVO deleteSharePost(int noneTradePostNo) {
		sharePostMapper.deleteSharePost(noneTradePostNo);
		return sharePostMapper.findDetailSharePost(noneTradePostNo);
		
	}
}
