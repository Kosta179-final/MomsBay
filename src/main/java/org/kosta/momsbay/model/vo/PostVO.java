package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PostVO {
	private String title;
	private String content;
	private String regdate;
	private int hits;
	private MemberVO memberVO;
}
