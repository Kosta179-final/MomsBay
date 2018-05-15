package org.kosta.momsbay;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.TradePostMapper;
import org.kosta.momsbay.model.vo.PostVO;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class TradePostMapperTest {
	@Autowired
	TradePostMapper mapper;
	
	/**
	 * 거래게시판의 글쓰기 테스트
	 * @author Jung
	 */
	/*@Test
	public void addTradePost() {
		TradePostVO vo = new TradePostVO();
		MemberVO mvo = new MemberVO();
		vo.setTitle("유모차 사고싶다...");
		vo.setContent("유모차 팔아줄사람 없나??");
		vo.setPrice(50000);
		vo.setMemberVO(mvo);
		vo.getMemberVO().setId("java");;
		vo.setCategoryNo(1);
		vo.setBoardTypeNo(1);
		mapper.addTradePost(vo);
	}
	
	*//**
	 * 총 게시물의 수를 반환해주는 테스트
	 * @author Jung
	 *//*
	@Test
	public void getTotalTradePostCount() {
		assertEquals(25, mapper.getTotalTradePostCount());
	}*/
	
	/**
	 * 페이징 처리된 거래게시판의 목록을 보여주는 테스트
	 * @author Jung
	 */
	@Test
	public void getTradePostList() {
		PagingBean pagingBean = new PagingBean(mapper.getTotalTradePostCount());
		pagingBean.setPostCountPerPage(9);
		List<PostVO> list = mapper.getTradePostList(pagingBean);
		for(int i=0;i<list.size();i++) {
			TradePostVO tp =  (TradePostVO) list.get(i);
			System.out.println(tp.getTitle()+ " "+tp.getTradePostNo());
			System.out.println(tp.getMemberVO().getName()+" "+tp.getPrice());
		}
	}
}