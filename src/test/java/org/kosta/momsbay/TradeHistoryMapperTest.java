package org.kosta.momsbay;

import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.TradeHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class TradeHistoryMapperTest {
	@Autowired
	TradeHistoryMapper mapper;

	@Test
	public void findTradeHistoryListById() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "java2");
		map.put("board_type_no", "1");
		//assertNotEquals(null, mapper.findTradeHistoryListById(map));
	}
	
}