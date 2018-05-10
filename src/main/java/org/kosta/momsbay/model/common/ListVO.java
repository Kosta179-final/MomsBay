package org.kosta.momsbay.model.common;

import java.util.ArrayList;

import org.kosta.momsbay.model.vo.PostVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListVO {
	private ArrayList<PostVO> list;
	private PagingBean pagingBean;
	
	public ListVO(PagingBean pagingBean) {
		super();
		this.pagingBean = pagingBean;
	}
	
}
