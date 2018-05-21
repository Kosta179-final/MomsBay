package org.kosta.momsbay.model.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class TradePostVO extends PostVO{
	private int tradePostNo;
	private int pickCount;
	private int price;
	private int categoryNo;
	private int boardTypeNo;
	private String status;
	private String tradeId;
	private boolean deleteStatus;
	private int wishPrice;
	private String suggestContent;
	private MultipartFile file; 
	private String imgAddress;
}
