package org.kosta.momsbay;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.SharePostMapper;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.SharePostVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class SharePostServiceTest {
	
	@Resource
	SharePostMapper sharePostMapper;
	
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
}
