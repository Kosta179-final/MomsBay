package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeHistoryVO {
	private int tradeHistoryNo;
	private String regdate;
	private String id;
	private String status;
	private MemberVO memberVO;
	private TradePostVO tradePostVO;
}
