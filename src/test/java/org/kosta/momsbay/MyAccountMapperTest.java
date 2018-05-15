package org.kosta.momsbay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class MyAccountMapperTest {
	@Autowired
	MemberMapper mapper;
	MemberVO member= new MemberVO();
	
	@Test
	public void updateMember() {
		member.setId("java");
		member.setPassword("1234");
		member.setAddress("수원22");
		member.setAddress2("1003");
		member.setName("hello");
		
		mapper.updateMember(member);
		
	}
}
