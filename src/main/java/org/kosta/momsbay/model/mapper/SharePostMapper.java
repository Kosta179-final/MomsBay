package org.kosta.momsbay.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.vo.PostVO;
import org.kosta.momsbay.model.vo.SharePostVO;
/**
 * 중고물품 게시판 관련 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface SharePostMapper {
	/**
	 * 나눔 게시판 글쓰기
	 * @param sharePostVO
	 * @author rws
	 */
	public void addSharePost(SharePostVO sharePostVO);
	
	/**
	 * 나눔 게시판 총게시글 갯수
	 * @return getTotalSharePostCount
	 * @author rws
	 */
	public int getTotalSharePostCount();
	
	/**
	 * 나눔 게시글 리스트
	 * @param pagingBean
	 * @return List<VO>
	 * @author rws
	 */
	public List<PostVO> getSharePostList(PagingBean pagingBean);
	
	/**
	 * 나눔 게시글 상세보기
	 * @param noneTradePostNo
	 * @return SharePostVO
	 * @author rws
	 */
	public SharePostVO findDetailSharePost(int noneTradePostNo);
	
	
	/**
	 * 나눔 게시글 수정
	 * @param sharePostVO
	 * @author rws
	 */
	public void updateSharePost(SharePostVO sharePostVO);
}
