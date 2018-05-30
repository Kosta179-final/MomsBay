package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.service.MemberPickService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.TradePostVO;
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
		TradePostVO tradePostVO = new TradePostVO();
		memberPickMapper.deleteMemberPick(tradePostVO);
	}
	
	/**
	 * 찜 추가 테스트.
	 */
	@Test
	public void addMemberPick() {
		TradePostVO tradePostVO = new TradePostVO();
		memberPickMapper.addMemberPick(tradePostVO);
	}
	
	/**
	 * 로그인한 사용자의 찜목록을 가져오는 메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void findPickListById() {
		assertNotEquals(null, memberPickMapper.findPickListById("java","1"));
	}
	
	/**
	 * 찜을 했는지 테스트
	 * @author Jung
	 */
	@Test
	public void isPickTradePost() {
		TradePostVO tradePostVO = new TradePostVO();
		MemberVO memberVO = new MemberVO();
		memberVO.setId("java");
		tradePostVO.setTradePostNo(145);
		tradePostVO.setMemberVO(memberVO);
		assertEquals(true, memberPickMapper.isPickTradePost(tradePostVO));
	}
	
	/**
	 * 찜 수 업데이트 테스트
	 * @author Jung
	 */
	@Test
	public void updatePickCount() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tradePostNo",145);
		map.put("count", 1);
		memberPickMapper.updatePickCount(map);
		System.out.println(memberPickMapper.findPickListById("java","1"));
	}
}
