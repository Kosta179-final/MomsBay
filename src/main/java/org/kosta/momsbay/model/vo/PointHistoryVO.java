package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointHistoryVO {
	private String id;
	private String regdate;
	private int price;
	private String type;
	private String now_point;
}
