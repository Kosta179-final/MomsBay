package org.kosta.momsbay;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.QnaPostMapper;
import org.kosta.momsbay.model.vo.PostVO;
import org.kosta.momsbay.model.vo.QnaPostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class BayPostMapperTest {
	@Autowired
	 QnaPostMapper qnaPostMapper;
	
	/**
	 * 페이징 처리된 Q&A 게시판의 목록을 보여주는 테스트
	 * @author sam
	 */
	@Test
	public void getQnaPostList() {
		PagingBean pagingBean = new PagingBean(qnaPostMapper.getTotalPostCount());
		pagingBean.setPostCountPerPage(1);
		List<PostVO> list = qnaPostMapper.getQnaPostList(pagingBean);
		for(int i=0;i<list.size();i++) {
			QnaPostVO qp =  (QnaPostVO) list.get(i);
			System.out.println(qp.getBayPostNo()+" "+qp.getTitle()+" "+qp.getName()+" "+qp.getRegdate());

		}
	}
}
