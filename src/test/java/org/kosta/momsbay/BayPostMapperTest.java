package org.kosta.momsbay;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.BayPostMapper;
import org.kosta.momsbay.model.mapper.QnaPostMapper;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.QnaPostVO;
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
		pagingBean.setPostCountPerPage(2);
		/*List<PostVO> list = qnaPostMapper.getQnaPostList(pagingBean);
		for(int i=0;i<list.size();i++) {
			QnaPostVO qp =  (QnaPostVO) list.get(i);
			System.out.println(qp.getBayPostNo()+" "+qp.getTitle()+" "+qp.getName()+" "+qp.getRegdate());
			
		}*/
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

	@Test
	public void addQnaPost() {
		QnaPostVO qnaPostVO=new QnaPostVO();
		qnaPostVO.setSubjectNo(1);
		qnaPostVO.setTitle("낼름");
		qnaPostVO.setContent("네루미입니다.");
		qnaPostVO.setMemberVO(new MemberVO());
		qnaPostVO.getMemberVO().setId("java");
		qnaPostVO.setBoardTypeNo(6);
		qnaPostMapper.addQnaPost(qnaPostVO);
	}

	@Test
	public void getPostDetail() {
		BayPostVO dbBayPostVO=mapper.getPostDetail(1);
		//assertEquals(bayPostVO, dbBayPostVO);
		//System.out.println(dbBayPostVO);
	}

	/*@Test
	public void deleteBoard(int bayPostNo) {
	}
*/
	@Test
	public void updateQnaPost() {
		
		QnaPostVO qnaPostVO=qnaPostMapper.getQnaDetail(6);
		qnaPostVO.setTitle("test..");
		qnaPostVO.setContent("test입니다..");
		qnaPostMapper.updateQnaPost(qnaPostVO);
		//System.out.println(qnaPostVO.getTitle() +" "+ qnaPostVO.getContent());
		//assertEquals(qnaPostMapper.getQnaDetail(6), qnaPostMapper.updateQnaPost(qnaPostVO));
	}
}