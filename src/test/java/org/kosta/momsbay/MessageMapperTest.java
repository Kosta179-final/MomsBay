package org.kosta.momsbay;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.mapper.MessageMapper;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.MessageVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * MessageMapper를 테스트 한다.
 * @author kim
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class MessageMapperTest {
	@Resource
	MessageMapper messageMapper;
	
	/**
	 * 메세지 수신 데이터를 db에 추가한다.
	 */
	@Test
	public void addReceiveMessage() {
		MessageVO messageVO=new MessageVO();
		messageVO.setTitle("test");
		messageVO.setContent("testing");
		messageVO.setMemberVO(new MemberVO());
		messageVO.getMemberVO().setId("sys");
		messageVO.setReceiveId("java");
		messageMapper.addReceiveMessage(messageVO);
	}
	/**
	 * 메세지 발신 데이터를 db에 추가한다.
	 */
	@Test
	public void addSendMessage() {
		MessageVO messageVO=new MessageVO();
		messageVO.setTitle("test");
		messageVO.setContent("testing");
		messageVO.setMemberVO(new MemberVO());
		messageVO.getMemberVO().setId("sys");
		messageVO.setReceiveId("java");
		messageMapper.addSendMessage(messageVO);
	}
}
