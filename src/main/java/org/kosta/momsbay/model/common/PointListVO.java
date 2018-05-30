package org.kosta.momsbay.model.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointListVO {
	private List<Object> list;
	private PagingBean pagingBean;
	
	public PointListVO(PagingBean pagingBean) {
		super();
		this.pagingBean = pagingBean;
	}
}
