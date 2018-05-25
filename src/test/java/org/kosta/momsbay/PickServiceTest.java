package org.kosta.momsbay;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.PickMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class PickServiceTest {
	@Autowired
	PickMapper pickMapper;
	
	/**
	 * 로그인한 사용자의 찜목록을 가져오는 메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void findPickListById() {
		assertNotEquals(null, pickMapper.findPickListById("java"));
	}
}
