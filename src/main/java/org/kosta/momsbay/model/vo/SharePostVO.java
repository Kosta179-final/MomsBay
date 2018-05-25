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
public class SharePostVO extends PostVO{
	private int noneTradePostNo;
	private int categoryNo;
	private int boardTypeNo;
	private int tradeStatusNo;
	private MultipartFile file; 
	private String imgAddress;
	private String category;
}
