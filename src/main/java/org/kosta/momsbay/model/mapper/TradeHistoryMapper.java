package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.TradePostVO;
/**
 * 거래내역 DB연동 Mapper.
 * 관련VO: TradeHistoryVO
 * @author Hwang
 */
@Mapper
public interface TradeHistoryMapper {
	/**
	 * id로 조회한 거래 내역 반환.
	 * @param id
	 * @return 거래 내역 리스트
	 * @author Jung
	 */
	public List<Object> findTradeHistoryListById(Map<String,Object> map);
	
	
	/**
	 * 거래 신청시 거래내역에 등록하는 메서드.
	 * @param tradeHistoryVO
	 * @author Jung
	 */
	public void addTradeHistory(TradePostVO tradePostVO);
	
	/**
	 * 거래 취소시 거래내역에 삭제하는 메서드.
	 * @param tradeHistoryVO
	 * @author Jung
	 */
	public void deleteTradeHistory(TradePostVO tradePostVO);
	
	
	/**
	 * 거래 완료시 거래상태를 거래중에서 거래완료로 변경하는 메서드.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateCompleteTradeHistory(TradePostVO tradePostVO);
	
	/**
	 * 판매자가 물품 배송시 거래상태를 거래중에서 물품배송으로 변경하는 메서드.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateDeliveryTradeHistory(TradePostVO tradePostVO);
	
	/**
	 * 아이디와 게시물번호로 판매자 거래내역의 거래상태를 조회.
	 * @param tradePostVO
	 * @return trade_status
	 * @author Jung
	 */
	public String findTradeStatusByIdAndTradePostNo(TradePostVO tradePostVO);

	/**
	 * 거래내역의 총 수
	 * @param map
	 * @return int
	 * @author Jung
	 */
	public int findTotalTradeHistoryCountById(Map<String,Object> map);
	
	/**
	 * 판매자가 입금 완료시 거래상태를 거래중에서 입금완료로 변경하는 메서드.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateDepositTradeHistory(TradePostVO tradePostVO);
}
