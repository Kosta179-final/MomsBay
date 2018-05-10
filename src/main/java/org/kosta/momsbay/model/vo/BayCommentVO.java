package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BayCommentVO {
	private int thread;
	private int depth;
	private String bayComment;
	private int bayPostNo;
	private String id;
}
