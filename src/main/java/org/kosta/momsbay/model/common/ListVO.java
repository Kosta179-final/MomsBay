package org.kosta.momsbay.model.common;

import java.util.List;

import org.kosta.momsbay.model.vo.PostVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListVO {
	private List<PostVO> list;
	private PagingBean pagingBean;
	
	public ListVO(PagingBean pagingBean) {
		super();
		this.pagingBean = pagingBean;
	}
}
