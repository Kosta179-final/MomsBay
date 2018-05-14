package org.kosta.momsbay.model.common;

import java.util.ArrayList;

import org.kosta.momsbay.model.vo.CommentVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentListVO {
	private ArrayList<CommentVO> list;
	private PagingBean pagingBean;
	
	public CommentListVO(PagingBean pagingBean) {
		super();
		this.pagingBean = pagingBean;
	}
	
}
