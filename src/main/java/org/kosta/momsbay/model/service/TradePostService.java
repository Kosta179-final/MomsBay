package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.TradePostMapper;
import org.kosta.momsbay.model.vo.TradePostVO;
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
	public ListVO getTradePostList(String pageNo,String boardTypeNo,String categoryNo) {
		PagingBean pagingBean=null;
		Map<String,Object> map = new HashMap();
		map.put("board_type_no", Integer.parseInt(boardTypeNo));
		map.put("category_no", Integer.parseInt(categoryNo));
		int totalCount=tradePostMapper.getTotalTradePostCount(map);
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(9);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(9);
		}
		map.put("pagingBean", pagingBean);
		return new ListVO(tradePostMapper.getTradePostList(map),pagingBean);
	}

	/**
	 * tradePostNo와 일치하는 TradePostVO를 반환해주는 메서드
	 * @param tradePostNo
	 * @return TradePostVO
	 */
	public TradePostVO findTradePostByTradePostNo(int tradePostNo) {
		return tradePostMapper.findTradePostByTradePostNo(tradePostNo);
	}

	public TradePostVO addTradePost(TradePostVO tradePostVO) {
		tradePostMapper.addTradePost(tradePostVO);
		return tradePostMapper.findTradePostByTradePostNo(tradePostVO.getTradePostNo());
	}
}
