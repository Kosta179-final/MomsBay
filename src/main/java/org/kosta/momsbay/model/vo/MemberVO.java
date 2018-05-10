package org.kosta.momsbay.model.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String address;
	private String email;
	private String tel;
	private int point;
	private String grade;
	private int rating;
	private List<ChildrenVO> list;
}
