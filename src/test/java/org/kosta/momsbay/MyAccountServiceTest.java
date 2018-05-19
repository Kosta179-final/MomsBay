package org.kosta.momsbay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.common.PointListVO;
import org.kosta.momsbay.model.mapper.PointHistoryMapper;
import org.kosta.momsbay.model.service.HistoryService;
import org.kosta.momsbay.model.service.PointService;
import org.kosta.momsbay.model.vo.PointHistoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-model.xml" })
public class MyAccountServiceTest {
	@Autowired
	HistoryService historyService;
	@Autowired
	PointService pointService;
	@Autowired

	@Test
	public void chargePoint() {
		String id = "java";
		String point = "500";
		String msg = "충전완료!";
		try {
			pointService.updateChargePoint(id, point);
			historyService.addPointChargeHistory(id, point);
		} catch (Exception e) {
			msg = "충전 중 오류가 났습니다. 다시 시도해주세요!";
		} finally {
			System.out.println(msg);
		}		
	}
	
	@Test
	public void exchangePoint(){
		String id="java";
		String exchangePoint="200";
		historyService.addPointExchangeHistory(id, exchangePoint);
	}
}