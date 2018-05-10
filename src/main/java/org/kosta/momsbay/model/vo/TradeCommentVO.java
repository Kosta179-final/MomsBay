package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeCommentVO {
	private int thread;
	private int depth;
	private String tradeComment;
	private int tradePostNo;
	private String id;
}

