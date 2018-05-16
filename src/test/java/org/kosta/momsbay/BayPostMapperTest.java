package org.kosta.momsbay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.BayPostMapper;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class BayPostMapperTest {
	@Autowired
	BayPostMapper mapper;
	/*@Test
	public void getBayPostList() {
		int totalCount=mapper.getTotalPostCount();
		PagingBean pagingBean=null;
		pagingBean=new PagingBean(totalCount);
		assertNotNull(mapper.getBayPostList(pagingBean));
	}

	@Test
	public void getTotalPostCount() {
		
	}
	*/

	@Test
	public void addPost() {
		BayPostVO bayPostVO=new BayPostVO();
		bayPostVO.setSubjectNo(1);
		bayPostVO.setTitle("test");
		bayPostVO.setContent("test입니다.");
		bayPostVO.setMemberVO(new MemberVO());
		bayPostVO.getMemberVO().setId("java");
		bayPostVO.setBoardTypeNo(5);
		mapper.addPost(bayPostVO);
	}

	@Test
	public void getPostDetail() {
		BayPostVO bayPostVO=new BayPostVO();
		bayPostVO.setSubjectNo(1);
		bayPostVO.setTitle("test");
		bayPostVO.setContent("test입니다.");
		bayPostVO.setMemberVO(new MemberVO());
		bayPostVO.getMemberVO().setId("java");
		bayPostVO.setBoardTypeNo(5);
		mapper.addPost(bayPostVO);
		BayPostVO dbBayPostVO=mapper.getPostDetail(bayPostVO.getBayPostNo());
		//assertEquals(bayPostVO, dbBayPostVO);
		System.out.println(dbBayPostVO);
	}

	/*@Test
	public void deleteBoard(int bayPostNo) {
	
	}

	@Test
	public void updateBoard(BayPostVO bayPostVO) {
	}*/
}