package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.service.BayPostService;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-model.xml")
public class BayPostServiceTest {
	@Autowired
	BayPostService bayPostService;
	
	@Test
	public void updatePost() {
		BayPostVO bayPostVO=bayPostService.getPostDetail(1);
		
		bayPostVO.setTitle("test1");
		bayPostVO.setContent("test입니다...");
		bayPostService.updatePost(bayPostVO);
		BayPostVO dbBayPostVO=bayPostService.getPostDetail(bayPostVO.getBayPostNo());
		assertEquals(bayPostVO.getTitle(), dbBayPostVO.getTitle());
		assertEquals(bayPostVO.getContent(), dbBayPostVO.getContent());
	}
}
