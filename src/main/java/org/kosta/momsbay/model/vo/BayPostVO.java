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
	private int bayPostNo;
	private int thread;
	private int depth;
	private String type;
	private int subjectNo;
	private String name;
	private int boardTypeNo;
}
