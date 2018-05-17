package org.kosta.momsbay.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.vo.PostVO;
import org.kosta.momsbay.model.vo.QnaPostVO;
/**
 * Q&A 게시판 DB연동 Mapper.
 * @author sam
 */
@Mapper
public interface QnaPostMapper {
	/**
	 * Q&A 게시판 글목록 리스트 메서드
	 * @param pagingBean
	 * @author sam
	 */
	public List<PostVO> getQnaPostList(PagingBean pagingBean);
	/**
	 * Q&A 게시판 총게시물수 메서드
	 * @author sam
	 */
	public int getTotalPostCount();
	/**
	 * Q&A 글쓰기 메서드
	 * @param qnaPostVO
	 * @author sam
	 */
	public void addQnaPost(QnaPostVO qnaPostVO);
	/**
	 * Q&A 게시판 글 상세보기 메서드
	 * @param bayPostNo
	 *  @author sam
	 */
	public QnaPostVO getQnaDetail(int bayPostNo);
}
