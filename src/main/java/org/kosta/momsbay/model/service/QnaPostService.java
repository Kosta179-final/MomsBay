package org.kosta.momsbay.model.service;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.QnaPostMapper;
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
	
	public ListVO getQnaPostList(String pageNo) {
		int totalCount=qnaPostMapper.getTotalPostCount();
		PagingBean pagingBean=null;
		if(pageNo==null)
			pagingBean=new PagingBean(totalCount);
		else
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
		return new ListVO(qnaPostMapper.getQnaPostList(pagingBean),pagingBean);
	}
}
