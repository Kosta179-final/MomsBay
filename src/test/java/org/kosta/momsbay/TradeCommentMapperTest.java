package org.kosta.momsbay;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.TradeCommentMapper;
import org.kosta.momsbay.model.vo.TradeCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class TradeCommentMapperTest {
	@Autowired
	TradeCommentMapper mapper;
	
	@Test
	public void testGetTradeCommentList() {
		List<TradeCommentVO> list = mapper.getTradeCommentList(1);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getId() + " " + list.get(i).getTradeComment());
		}
		
	}
}
