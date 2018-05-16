package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.exception.LoginException;
import org.kosta.momsbay.model.service.MemberService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class MemberServiceTest {
	@Autowired
	MemberService service;
	
	@Test
	public void login() {
		MemberVO sampleMember1= new MemberVO();
		MemberVO sampleMember2= new MemberVO();
		MemberVO sampleMember3= new MemberVO();
		MemberVO dbMember;
		try {
			sampleMember1.setId("java");
			sampleMember1.setPassword("1234");
			dbMember = service.login(sampleMember1.getId(), sampleMember1.getPassword());
			assertEquals(sampleMember1.getId(),dbMember.getId());
			assertEquals(sampleMember1.getPassword(),dbMember.getPassword());
			
			sampleMember2.setId("java");
			sampleMember2.setPassword("123");
			dbMember = service.login(sampleMember2.getId(), sampleMember2.getPassword());
		} catch (LoginException e) {
			assertEquals(e.getMessage(), "비밀번호가 다릅니다");
		}
		try {
			sampleMember3.setId("jjjj");
			sampleMember3.setPassword("1234");
			dbMember = service.login(sampleMember3.getId(), sampleMember3.getPassword());
		} catch (LoginException e) {
			assertEquals(e.getMessage(), "아이디가 존재하지 않습니다");
		}
	}
}
