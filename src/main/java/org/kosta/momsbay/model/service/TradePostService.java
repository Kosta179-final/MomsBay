package org.kosta.momsbay.model.service;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.TradePostMapper;
import org.springframework.stereotype.Service;

/**
 * 교환게시판 관련 비즈니스로직 서비스.
 * 관련Mapper: TradePostMapper
 * @author Ryu
 */
@Service
public class TradePostService {
	@Resource
	private TradePostMapper tradePostMapper;
	
	/**
	 * 거래게시판의 목록을 출력해주는 메서드.
	 * @param pageNo
	 * @return ListVO
	 * @author Jung
	 */
	public ListVO getTradePostList(String pageNo) {
		int totalCount=tradePostMapper.getTotalTradePostCount();
		PagingBean pagingBean=null;
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(9);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(9);
		}
		return new ListVO(tradePostMapper.getTradePostList(pagingBean),pagingBean);
	}
}
