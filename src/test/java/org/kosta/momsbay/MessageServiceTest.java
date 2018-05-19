package org.kosta.momsbay;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.service.MessageService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.MessageVO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MessageService메서드를 Test한다.
 * @author kim
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class MessageServiceTest {
	@Resource
	MessageService messageService;
	
	/**
	 * addMessage메서드에 Transaction처리가 잘되는지 테스트 한다.
	 */
	@Test
	public void addMessage() {
		MessageVO messageVO=new MessageVO();
		messageVO.setTitle("test");
		messageVO.setContent("testing");
		messageVO.setMemberVO(new MemberVO());
		messageVO.getMemberVO().setId("sys");
		messageVO.setReceiveMemberVO(new MemberVO());
		messageVO.getReceiveMemberVO().setId("java");
		messageService.addMessage(messageVO);
	}
	/**
	 * Service안에서 총 Message갯수를 출력한 뒤 List를 받아옴
	 */
	@Test
	public void getReceiveMessageList() {
		String receiveId="sys";
		String pageNo="1";
		assertNotNull(messageService.getReceiveMessageList(receiveId,null));
		assertNotNull(messageService.getReceiveMessageList(receiveId,pageNo));
	}
}
