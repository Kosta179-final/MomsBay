package org.kosta.momsbay;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.BayPostMapper;
import org.kosta.momsbay.model.mapper.QnaPostMapper;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class BayPostMapperTest {
	@Autowired
	 QnaPostMapper qnaPostMapper;
	
	
	@Autowired
	BayPostMapper mapper;
	/**
	 * 페이징 처리된 Q&A 게시판의 목록을 보여주는 테스트
	 * @author sam
	 */
	@Test
	public void getQnaPostList() {
		PagingBean pagingBean = new PagingBean(qnaPostMapper.getTotalPostCount());
		pagingBean.setPostCountPerPage(1);
		List<PostVO> list = qnaPostMapper.getQnaPostList(pagingBean);
	}
	
	@Test
	public void getBayPostList() {
		int totalCount=mapper.getTotalPostCount();
		PagingBean pagingBean=null;
		pagingBean=new PagingBean(totalCount);
		assertNotNull(mapper.getBayPostList(pagingBean));
	}
	
	/*@Test
	public void getTotalPostCount() {
		
	}*/

/*	@Test
	public void addPost() {
		BayPostVO bayPostVO=new BayPostVO();
		bayPostVO.setSubjectNo(1);
		bayPostVO.setTitle("test");
		bayPostVO.setContent("test입니다.");
		bayPostVO.setMemberVO(new MemberVO());
		bayPostVO.getMemberVO().setId("java");
		bayPostVO.setBoardTypeNo(5);
		mapper.addPost(bayPostVO);
	}*/

	@Test
	public void getPostDetail() {
		BayPostVO dbBayPostVO=mapper.getPostDetail(1);
		//assertEquals(bayPostVO, dbBayPostVO);
	}

	@Test
	public void deleteBoard(int bayPostNo) {
	
	}
/**/
	@Test
	public void updateBoard() {
		BayPostVO bayPostVO=new BayPostVO();
		bayPostVO.setBayPostNo(1);
		bayPostVO.getSubjectVO().setSubjectNo(1);
		bayPostVO.setTitle("test");
		bayPostVO.setContent("test입니다.");
		bayPostVO.setMemberVO(new MemberVO());
		bayPostVO.getMemberVO().setId("java");
		bayPostVO.setBoardTypeNo(5);
		mapper.updateBoard(bayPostVO);
		BayPostVO dbBayPostVO=mapper.getPostDetail(bayPostVO.getBayPostNo());
	}
}