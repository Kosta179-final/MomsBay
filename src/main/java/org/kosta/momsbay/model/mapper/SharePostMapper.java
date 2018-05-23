package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
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
	@SuppressWarnings("rawtypes")
	public int getTotalSharePostCount(Map map);
	
	/**
	 * 나눔 게시글 리스트
	 * @param pagingBean
	 * @return List<VO>
	 * @author rws
	 */
	@SuppressWarnings("rawtypes")
	public List<PostVO> getSharePostList(Map map);
	
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
	
	/**
	 * 나눔 게시글 삭제
	 * @param sharePostVO
	 * @author rws
	 */
	public void deleteSharePost(int noneTradePostNo);
	
	/**
	 * 나눔 게시글 거래상태 변경
	 * @param noneTradePostNo
	 * @author rws
	 */
	public void updateSharePostByStatus(int noneTradePostNo);
	
	/**
	 * 나눔 게시판 카테고리명 불러오기
	 * @param categoryNo
	 * @return categoryNo
	 * @author rws
	 */
	public String findCategory(int categoryNo);
}
