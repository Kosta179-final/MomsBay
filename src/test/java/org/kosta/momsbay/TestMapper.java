package org.kosta.momsbay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.vo.ChildrenVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class TestMapper {
	@Autowired
	MemberMapper mm;
	MemberVO vo;
	ChildrenVO chvo = new ChildrenVO();
	
	@Test
	public void contextLoads() {
/*		MemberVO vo = mm.findMemberById("java");
		System.out.println(vo.getPassword());
		System.out.println(chvo.getBirth());*/
		
	}
}
