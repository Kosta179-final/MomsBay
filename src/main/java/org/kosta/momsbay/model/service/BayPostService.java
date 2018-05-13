package org.kosta.momsbay.model.service;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.BayPostMapper;
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
	
	public ListVO getBayPostList(String pageNo) {
		int totalCount=bayPostMapper.getTotalPostCount();
		PagingBean pagingBean=null;
		if(pageNo==null)
			pagingBean=new PagingBean(totalCount);
		else
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
		return new ListVO(bayPostMapper.getBayPostList(pagingBean),pagingBean);
	}
}
