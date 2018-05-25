package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.service.TradePostService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class TradePostServiceTest {
	@Autowired
	TradePostService tradePostService;
	
	/**
	 * 페이징 처리된 거래게시판의 목록을 보여주는 테스트
	 * @author Jung
	 */
	@Test
	public void getTradePostList() {
		assertNotNull(tradePostService.getTradePostList("1","1",null,"1"));
	}
	
	/**
	 * 번호에 해당하는 상세보기를 테스트
	 * @author Jung
	 */
	@Test
	public void findTradePostByTradePostNo() {
		assertNotEquals(null, tradePostService.findTradePostByTradePostNo(2));
	}
	
	
	/**
	 * 게시글을 삭제하는 메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void deleteTradePost() {
		assertEquals(null,tradePostService.findTradePostByTradePostNo(10));
	}
	
	/**
	 * 거래게시판의 글쓰기 메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void addTradePost() {
		TradePostVO tradePostVO = new TradePostVO();
		MemberVO memberVO = new MemberVO();
		memberVO.setId("java");
		tradePostVO.setMemberVO(memberVO);
		tradePostVO.setTitle("몰라요");
		tradePostVO.setContent("내용도 몰라요");
		tradePostVO.setPrice(10000);
		tradePostVO.setCategoryNo(1);
		tradePostVO.setBoardTypeNo(2);
		tradePostService.addTradePost(tradePostVO);
	}
	
	/**
	 * 거래게시판 게시글수정 테스트.
	 * @author Jung
	 */
	@Test
	public void updateTradePost() {
		TradePostVO tradePostVO = new TradePostVO();
		tradePostVO.setTitle("몰라요");
		tradePostVO.setContent("내용도 몰라요");
		tradePostVO.setPrice(10000);
		tradePostVO.setTradePostNo(130);
		tradePostService.updateTradePost(tradePostVO);
	}
	
	/**
	 * 사진경로 추가 테스트.
	 * @author Jung
	 */
	@Test
	public void addTradePostPhoto() {
		String path = "123";
		int tradePostNo = 130;
		tradePostService.addTradePostPhoto(path, tradePostNo);
	}
	
	/**
	 * 게시물번호에 해당하는 사진 경로를 찾는 메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void findTradePostImgByPostNo() {
		tradePostService.findTradePostImgByPostNo(130);
	}
	
	/**
	 * 거래게시판의 거래신청자 추가메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void updateTradeId() {
		TradePostVO tradePostVO = new TradePostVO();
		tradePostVO.setTradePostNo(130);
		tradePostVO.setTradeId("spring");
		tradePostService.updateTradeId(tradePostVO);
	}
	
	
	/**
	 * 거래게시판의 신청자 삭제메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void deleteTradeId() {
		tradePostService.deleteTradeId(130);
	}
	
	/**
	 * 게시물번호에 해당하는 게시글의 가격 조회메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void findPirceByTradePostNo() {
		tradePostService.findPirceByTradePostNo(130);
	}
	
}

