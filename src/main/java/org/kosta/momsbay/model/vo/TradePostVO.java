package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class TradePostVO extends PostVO{
	private int pick_count;
	private int price;
	private String category;
	private String type;
	private String status;
}
