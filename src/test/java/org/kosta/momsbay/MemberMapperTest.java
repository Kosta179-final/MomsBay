package org.kosta.momsbay;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class MemberMapperTest {
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void findMemberExsitById() {
		MemberVO member= new MemberVO();
		member.setId("java");
		member.setPassword("1234");
		assertTrue(mapper.findMemberExsitById(member.getId()));
	}
	
	@Test
	public void findMemberIdByPart() {
		String id="pik";
		String temp_id=id+"%";
		System.out.println(mapper.findMemberIdByPart(temp_id));
	}
	
	@Test
	public void getMemberChildStatistics() {
		Map<String, String> map = new HashMap<>();
		map.put("female",mapper.getMemberChildStatistics("female"));
		map.put("male",mapper.getMemberChildStatistics("male"));
		System.out.println(map);
	}
}
