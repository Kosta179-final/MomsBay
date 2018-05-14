package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class TradeCommentVO extends CommentVO{
	private String tradeComment;
	private int tradePostNo;
}

