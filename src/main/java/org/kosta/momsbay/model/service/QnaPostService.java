package org.kosta.momsbay.model.service;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.QnaPostMapper;
import org.kosta.momsbay.model.vo.QnaPostVO;
import org.springframework.stereotype.Service;
/**
 * Q&A 게시판 관련 비즈니스로직 서비스.
 * 관련Mapper: QnaPostMapper
 * @author sam
 */
@Service
public class QnaPostService {
	@Resource
	private QnaPostMapper qnaPostMapper;
	/**
	 * @param pageNo
	 * Q&A 글목록 & pagingbean처리 메서드
	 */
	public ListVO getQnaPostList(String pageNo) {
		int totalCount=qnaPostMapper.getTotalPostCount();
		PagingBean pagingBean=null;
		if(pageNo==null)
			pagingBean=new PagingBean(totalCount);
		else
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
		return new ListVO(qnaPostMapper.getQnaPostList(pagingBean),pagingBean);
	}
	/**
	 * @param bayPostNo
	 * Q&A 글목록 상세보기 메서드
	 */
	public QnaPostVO getQnaDetail(int bayPostNo) {
		return qnaPostMapper.getQnaDetail(bayPostNo);
	}
}
