package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.MemberPickMapper;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.stereotype.Service;
/**
 * 찜관련 서비스 제공.
 * 관련Mapper: MemberPickMapper
 * @author Hwang
 */
@Service
public class MemberPickService {
	@Resource
	private MemberPickMapper memberPickMapper;
	
	/**
	 * 찜 삭제.
	 * @param memberPickVO
	 * @author Jung
	 */
	public void deleteMemberPick(TradePostVO tradePostVO) {
		memberPickMapper.deleteMemberPick(tradePostVO);
	}
	
	/**
	 * 찜 추가.
	 * @param memberPickVO
	 * @author Jung
	 */
	public void addMemberPick(TradePostVO tradePostVO) {
		memberPickMapper.addMemberPick(tradePostVO);
	}
	
	/**
	 * 아이디로 전체 찜목록을 가져오는 메서드.
	 * @param id
	 * @return List<TradePostVO>
	 * @author Jung
	 */
	public ListVO findPickListById(String id,String nowPage) {
		PagingBean pagingBean=null;
		Map<String,Object> map = new HashMap<String,Object>();
		int totalCount=memberPickMapper.findTotalPickCountById(id);
		if(nowPage==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(5);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(nowPage));
			pagingBean.setPostCountPerPage(5);
		}
		map.put("pagingBean", pagingBean);
		map.put("id", id);
		return new ListVO(memberPickMapper.findPickListById(map),pagingBean);
	}
	
	/**
	 * 아이디로 paing처리 찜목록을 가져오는 메서드.
	 * @param id
	 * @return List<TradePostVO>
	 * @author Jung
	 */
	public List<TradePostVO> findAllPickListById(String id) {
		return memberPickMapper.findAllPickListById(id);
	}
	
	/**
	 * trade_post_no가 찜 목록에 있는지 확인하는 메서드
	 * @param tradePostVO
	 * @return 찜 목록에 있으면 true, 없으면 false
	 * @author Jung
	 */
	public boolean isPickTradePost(TradePostVO tradePostVO) {
		return memberPickMapper.isPickTradePost(tradePostVO);
	}
	
	/**
	 * 찜 수를 업데이트 하는 메서드
	 * @param map
	 * @author Jung
	 */
	@SuppressWarnings("rawtypes")
	public void updatePickCount(Map map) {
		memberPickMapper.updatePickCount(map);
	}

	public String memberPick(TradePostVO tradePostVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(memberPickMapper.isPickTradePost(tradePostVO)) {
			map.put("tradePostNo", tradePostVO.getTradePostNo());
			map.put("count", -1);
			memberPickMapper.deleteMemberPick(tradePostVO);
			memberPickMapper.updatePickCount(map);
			return "1";
		} else {
			map.put("tradePostNo", tradePostVO.getTradePostNo());
			map.put("count", +1);
			memberPickMapper.addMemberPick(tradePostVO);
			memberPickMapper.updatePickCount(map);
			return "2";
		}
	}
	
}
