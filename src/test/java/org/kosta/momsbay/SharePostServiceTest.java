package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.SharePostMapper;
import org.kosta.momsbay.model.service.SharePostService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.SharePostVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class SharePostServiceTest {
	
	@Resource
	SharePostMapper sharePostMapper;
	@Resource
	SharePostService sharePostService;
	
	/**
	 * 나눔 게시판 글쓰기 테스트
	 * @author rws
	 */
	@Test
	public void shareWrite() {
		SharePostVO svo=new SharePostVO();
		MemberVO mvo=new MemberVO();
		svo.setTitle("제목입니다");
		svo.setContent("내용입니다");
		svo.setRegdate("2018-01-01");
		mvo.setId("spring");
		svo.setMemberVO(mvo);
		svo.setCategoryNo(2);
		svo.setBoardTypeNo(3);
		sharePostMapper.addSharePost(svo);
	}
	
	/**
	 * 나눔 게시판 리스트 테스트
	 * @author rws
	 */
	@Test
	public void getSharePostList() {
		assertNotNull(sharePostService.getSharePostList("1", "3", "1"));
	}
	
	/**
	 * 나눔 게시판 상세보기 테스트
	 * @author rws
	 */
	@Test
	public void findDetailSharePost() {
		assertNotNull(sharePostMapper.findDetailSharePost(86));
	}
	
	/**
	 * 나눔 게시판 내용수정 테스트
	 * @author rws
	 */
	@Test
	public void updateSharePost() {
		SharePostVO svo=new SharePostVO();
		svo.setNoneTradePostNo(82);
		svo.setTitle("변경하자");
		svo.setContent("변경하자");
		sharePostMapper.updateSharePost(svo);
	}
	
	/**
	 * 나눔 게시판 글삭제 테스트
	 * @author rws
	 */
	@Test
	public void deleteSharePost() {
		assertNotNull("성공",sharePostService.deleteSharePost(93));
	}
	
	/**
	 * 나눔 게시판 거래상태 변경 테스트
	 * @author rws
	 */
	@Test
	public void updateSharePostByStatus() {
		assertNotNull(null, sharePostService.updateSharePostByStatus(120));
	}
}
