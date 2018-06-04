package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.Map;

import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.common.PointListVO;
import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.mapper.PointHistoryMapper;
import org.kosta.momsbay.model.mapper.TradeHistoryMapper;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 포인트와 거래내역 처리 비즈니스로직 서비스.
 * 관련Mapper: PointHistoryMapper, TradeHistoryMapper
 * @author 개발제발
 */
@Service
public class HistoryService {
	@Autowired
	PointHistoryMapper pointHistoryMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	TradeHistoryMapper tradeHistoryMapper;
	
	/**
	 * id로 조회한 포인트 내역 반환.
	 * @param id
	 * @return 포인트 내역 리스트
	 */
	public PointListVO getPointHistoryById(String id, String pageNo) {
		/*List<PointHistoryVO> pointHistory=pointHistoryMapper.getPointHistoryById(id);*/
		PagingBean pagingBean=null;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		int totalCount=pointHistoryMapper.getTotalPointHistoryById(id);
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(10);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(10);
		}
		map.put("pagingBean", pagingBean);
		return new PointListVO(pointHistoryMapper.getPointHistoryById(map),pagingBean);
	}
	
	/**
	 * 포인트 내역을 남기는 서비스를 제공.
	 * 현재 포인트도 id로 찾아서 남긴다.
	 * @param id
	 * @param point
	 */
	public void addPointChargeHistory(String id, int chargePoint) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nPoint = memberMapper.findNowpointById(id);
		map.put("id", id);
		map.put("point", chargePoint);
		map.put("nowPoint", nPoint);
		pointHistoryMapper.addPointChargeHistory(map);
	}

	public void addPointExchangeHistory(String id, int exchangePoint) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nPoint = memberMapper.findNowpointById(id);
		map.put("id", id);
		map.put("point", exchangePoint);
		map.put("nowPoint", nPoint);
		pointHistoryMapper.addPointExchangeHistory(map);
	}
	
	public void addPointSellHistory(String id, int sellPoint) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nPoint = memberMapper.findNowpointById(id);
		map.put("id", id);
		map.put("point", sellPoint);
		map.put("nowPoint", nPoint);
		pointHistoryMapper.addPointSellHistory(map);
	}
	
	public void addPointBuyHistory(String id, int buyPoint) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nPoint = memberMapper.findNowpointById(id);
		map.put("id", id);
		map.put("point", buyPoint);
		map.put("nowPoint", nPoint);
		pointHistoryMapper.addPointBuyHistory(map);
	}
	
	/**
	 * id로 조회한 거래 내역 반환.
	 * @param id
	 * @return 거래 내역 리스트
	 * @author Jung
	 */
	public PointListVO findTradeHistoryListById(String id,String tradeType,String nowPage){
		PagingBean pagingBean=null;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("tradeType", tradeType);
		int totalCount=tradeHistoryMapper.findTotalTradeHistoryCountById(map);
		if(nowPage==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(5);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(nowPage));
			pagingBean.setPostCountPerPage(5);
		}
		map.put("pagingBean", pagingBean);
		return new PointListVO(tradeHistoryMapper.findTradeHistoryListById(map),pagingBean);
	}
	
	/**
	 * 거래 신청시 거래내역에 등록하는 메서드.
	 * @param tradeHistoryVO
	 * @author Jung
	 */
	public void addTradeHistory(TradePostVO tradePostVO) {
		tradeHistoryMapper.addTradeHistory(tradePostVO);
	}
	
	/**
	 * 거래 취소시 거래내역에 삭제하는 메서드.
	 * @param tradeHistoryVO
	 * @author Jung
	 */
	public void deleteTradeHistory(TradePostVO tradePostVO) {
		tradeHistoryMapper.deleteTradeHistory(tradePostVO);
	}
	
	/**
	 * 거래 완료시 거래내역의 거래상태를 거래완료로 수정하는 메서드.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateCompleteTradeHistory(TradePostVO tradePostVO) {
		tradeHistoryMapper.updateCompleteTradeHistory(tradePostVO);
	}

	/**
	 * 판매자가 물품 배송시 거래내역의 거래상태를 물품배송으로 수정하는 메서드.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateDeliveryTradeHistory(TradePostVO tradePostVO) {
		tradeHistoryMapper.updateDeliveryTradeHistory(tradePostVO);
	}
	
	
	public PointListVO getPointHistoryByIdAndDate(String id, String pageNo, String startDate, String endDate) {
		PagingBean pagingBean=null;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		int totalCount=pointHistoryMapper.getTotalPointHistoryByIdAndDate(map);
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(10);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(10);
		}
		map.put("pagingBean", pagingBean);
		return new PointListVO(pointHistoryMapper.getPointHistoryByIdAndDate(map),pagingBean);
	}

	/**
	 * 게시물 상태 반환
	 * @param tradePostVO
	 * @return trade_stats
	 * @author Jung
	 */
	public String findTradeStatusByIdAndTradePostNo(TradePostVO tradePostVO) {
		return tradeHistoryMapper.findTradeStatusByIdAndTradePostNo(tradePostVO);
	}
	
	/**
	 * 판매자가 입금 완료시 거래상태를 거래중에서 입금완료로 변경하는 메서드.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateDepositTradeHistory(TradePostVO tradePostVO) {
		tradeHistoryMapper.updateDepositTradeHistory(tradePostVO);
	}
	
}
