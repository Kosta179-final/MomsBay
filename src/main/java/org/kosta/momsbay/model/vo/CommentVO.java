package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CommentVO {
	private int bayCommentNo;
	private String bayCommentContent;
	private String bayCommentRegdate;
	private String id;
}
