package org.kosta.momsbay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.ChildrenMapper;
import org.kosta.momsbay.model.vo.ChildrenStatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-model.xml")
public class ChildrenMapperTest {
	@Autowired
	ChildrenMapper childrenMapper;
	
	@Test
	public void getChildrenAgeStatistics() {
		List<ChildrenStatisticsVO> list = new ArrayList<>();
		ChildrenStatisticsVO ch= new ChildrenStatisticsVO();
		Map<String, Object> map = new HashMap<>();
		map.put("gender", "male");
		ch=childrenMapper.getChildrenAgeStatistics(0);
		ch.setAge("2세 미만");
		list.add(ch);
		
		for(int i=1;i<11;i++) {
			ChildrenStatisticsVO temp_ch= new ChildrenStatisticsVO();
			temp_ch=childrenMapper.getChildrenAgeStatistics(i);
			temp_ch.setAge(i+1+"세");
			list.add(temp_ch);
		}
		System.out.println(list);
	}
}
