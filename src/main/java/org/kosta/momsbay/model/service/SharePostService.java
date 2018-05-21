package org.kosta.momsbay.model.service;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.PhotoUploadMapper;
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
	@Resource
	private PhotoUploadMapper photoUploadMapper;
	
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
	public ListVO getSharePostList(String pageNo, String boardTypeNo, String categoryNo, String searchWord){
		PagingBean pagingBean=null;
		Map<String, Object> map=new HashMap();
		map.put("board_type_no", Integer.parseInt(boardTypeNo));
		map.put("category_no", Integer.parseInt(categoryNo));
		map.put("searchWord", searchWord);
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
	 * @param noneTradePostNo
	 * @return noneTradePostNo
	 * @author rws
	 */
	public SharePostVO deleteSharePost(int noneTradePostNo) {
		sharePostMapper.deleteSharePost(noneTradePostNo);
		return sharePostMapper.findDetailSharePost(noneTradePostNo);
	}
	
	/**
	 * 나눔게시글 거래상태 변경
	 * @param noneTradePostNo
	 * @return noneTradePostNo
	 * @author rws
	 */
	public SharePostVO updateSharePostByStatus(int noneTradePostNo) {
		sharePostMapper.updateSharePostByStatus(noneTradePostNo);
		return sharePostMapper.findDetailSharePost(noneTradePostNo);
	}
	/**
	 * 파일 업로드 하는 메소드.
	 * @param uploadPath
	 * @param noneTradePostNo
	 * @param id
	 * @author hwangma
	 */
	public void addSharePostPhoto(String uploadPath, int noneTradePostNo) {
		Map<String, Object> map= new HashMap<>();
		map.put("path",uploadPath);
		map.put("postNo", noneTradePostNo);
		photoUploadMapper.insertPostPhoto(map);
	}
	/**
	 * 업로드된 메인이미지의 주소를 찾아오는 메소드.
	 * @param noneTradePostNo
	 * @return 사진위치 주소
	 * @author hwangma
	 */
	public String findSharePostImgByPostNo(int noneTradePostNo) {
		String imgAddress=photoUploadMapper.findSharePostImgByPostNo(noneTradePostNo);
		return imgAddress;
	}
}
