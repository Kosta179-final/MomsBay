package org.kosta.momsbay;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.TradeHistoryMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class TradeHistoryMapperTest {
	@Resource
	TradeHistoryMapper tradeHistoryMapper;
	
	@Test
	public void findTradeHistoryListById() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "java");
		map.put("board_type_no", "1");
		tradeHistoryMapper.findTradeHistoryListById(map);
	}
	
}