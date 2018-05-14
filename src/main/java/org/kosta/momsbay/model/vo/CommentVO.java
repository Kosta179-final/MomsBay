package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CommentVO {
	private int thread;
	private int depth;
	private String id;
}
