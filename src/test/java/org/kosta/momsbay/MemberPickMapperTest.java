package org.kosta.momsbay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.service.MemberPickService;
import org.kosta.momsbay.model.vo.MemberPickVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class MemberPickMapperTest {
	@Autowired
	MemberPickService memberPickMapper;
	
	/**
	 * 찜 삭제 테스트.
	 */
	@Test
	public void deleteMemberPick() {
		MemberPickVO memberPickVO = new MemberPickVO("java",1);
		memberPickMapper.deleteMemberPick(memberPickVO);
	}
	
	/**
	 * 찜 추가 테스트.
	 */
	@Test
	public void addMemberPick() {
		MemberPickVO memberPickVO = new MemberPickVO("java",1);
		memberPickMapper.addMemberPick(memberPickVO);
	}
}
