package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class BayPostVO extends PostVO{
	private int BayPostNo;
	private int thread;
	private int depth;
	private String type;
	private String subject;
	private String name;
}
