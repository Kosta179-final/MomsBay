package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.List;
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

	/**
	 * 게시판에 글을쓰고 자신이 쓴 글을 리턴해주는 메서드.
	 * @param tradePostVO
	 * @return TradePostVO
	 * @author Jung
	 */
	public TradePostVO addTradePost(TradePostVO tradePostVO) {
		tradePostMapper.addTradePost(tradePostVO);
		return tradePostMapper.findTradePostByTradePostNo(tradePostVO.getTradePostNo());
	}

	/**
	 * 해당 게시글을 삭제해주는 메서드
	 * @param tradePostNo
	 * @return TradePostVO
	 * @author Jung
	 */
	public TradePostVO deleteTradePost(int tradePostNo) {
		tradePostMapper.deleteTradePost(tradePostNo);
		return tradePostMapper.findTradePostByTradePostNo(tradePostNo);
	}
	
	/**
	 * 해당 게시물을 업데이트하는 메서드.
	 * @param tradePostNo
	 * @return TradePostVO
	 * @author Jung
	 */
	public TradePostVO updateTradePost(TradePostVO tradePostVO) {
		tradePostMapper.updateTradePost(tradePostVO);
		return tradePostMapper.findTradePostByTradePostNo(tradePostVO.getTradePostNo());
	}

	
	/**
	 * 아이디로 찜목록을 가져오는 메서드.
	 * @param id
	 * @return List<TradePostVO>
	 * @author Jung
	 */
	public List<TradePostVO> findPickListById(String id) {
		return tradePostMapper.findPickListById(id);
	}
}
