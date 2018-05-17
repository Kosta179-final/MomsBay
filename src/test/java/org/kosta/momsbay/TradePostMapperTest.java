package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.TradePostMapper;
import org.kosta.momsbay.model.vo.MemberVO;
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
	@Test
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
	
	/**
	 * 총 게시물의 수를 반환해주는 테스트
	 * @author Jung
	 */
	@Test
	public void getTotalTradePostCount() {
		Map<String,Object> map = new HashMap();
		map.put("board_type_no", 1);
		map.put("category_no", 1);
		assertEquals(33, mapper.getTotalTradePostCount(map));
	}
	
	/**
	 * 페이징 처리된 거래게시판의 목록을 보여주는 테스트
	 * @author Jung
	 */
	@Test
	public void getTradePostList() {
		Map<String,Object> map = new HashMap();
		map.put("board_type_no", 1);
		map.put("category_no", 1);
		PagingBean pagingBean = new PagingBean(mapper.getTotalTradePostCount(map));
		pagingBean.setPostCountPerPage(9);
		map.put("pagingBean", pagingBean);
		List<PostVO> list = mapper.getTradePostList(map);
		for(int i=0;i<list.size();i++) {
			TradePostVO tp =  (TradePostVO) list.get(i);
			System.out.println(tp.getTitle()+ " "+tp.getTradePostNo());
			System.out.println(tp.getMemberVO().getName()+" "+tp.getPrice());
		}
	}
	
	/**
	 * 번호에 해당하는 상세보기를 테스트.
	 * @author Jung
	 */
	@Test
	public void findTradePostByTradePostNo() {
		assertNotEquals(null, mapper.findTradePostByTradePostNo(2));
	}
	
	
	/**
	 * 게시글을 삭제하는 메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void deleteTradePost() {
		mapper.deleteTradePost(10);
		//assertEquals(null, mapper.findTradePostByTradePostNo(10));
	}
	
	
	/**
	 * 로그인한 사용자의 찜목록을 가져오는 메서드 테스트.
	 * @author Jung
	 */
	@Test
	public void findPickListById() {
		assertNotEquals(null, mapper.findPickListById("java"));
	}
	
}











