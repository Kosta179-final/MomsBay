package org.kosta.momsbay;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.service.TradePostService;
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
		assertNotNull(tradePostService.getTradePostList(null));
		System.out.println(tradePostService.getTradePostList(null).getList());
	}
}