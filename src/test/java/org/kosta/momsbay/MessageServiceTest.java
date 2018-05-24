package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.ListVO;
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
	MessageVO messageVO=new MessageVO();
	
	/**
	 * addMessage메서드에 Transaction처리가 잘되는지 테스트 한다.
	 */
	@Test
	public void addMessage() {
		messageVO.setTitle("test");
		messageVO.setContent("testing");
		messageVO.setMemberVO(new MemberVO());
		messageVO.getMemberVO().setId("sys");
		messageVO.setReceiveMemberVO(new MemberVO());
		messageVO.getReceiveMemberVO().setId("java");
		messageService.addMessage(messageVO);
	}
	/**
	 * Service안에서 총 받은Message갯수를 출력한 뒤 List를 받아옴
	 */
	@Test
	public void getReceiveMessageList() {
		String receiveId="java";
		String pageNo="1";
		String status="0";
		ListVO listVO=null;
		listVO=messageService.getReceiveMessageList(receiveId,null,null);
		assertFalse(listVO.getList().isEmpty());
		assertNotNull(listVO.getPagingBean());
		
		listVO=messageService.getReceiveMessageList(receiveId,pageNo,null);
		assertFalse(listVO.getList().isEmpty());
		assertNotNull(listVO.getPagingBean());

		listVO=messageService.getReceiveMessageList(receiveId,null,status);
		assertFalse(listVO.getList().isEmpty());

		listVO=messageService.getReceiveMessageList(receiveId,pageNo,status);
		assertFalse(listVO.getList().isEmpty());
		assertNotNull(listVO.getPagingBean());
	}
	/**
	 * Service안에서 총 보낸Message갯수를 출력한 뒤 List를 받아옴
	 */
	@Test
	public void getSendMessageList() {
		String sendId="sys";
		String pageNo="1";
		ListVO listVO=null;
		listVO=messageService.getSendMessageList(sendId,null);
		assertFalse(listVO.getList().isEmpty());
		assertNotNull(listVO.getPagingBean());

		listVO=messageService.getSendMessageList(sendId,pageNo);
		assertFalse(listVO.getList().isEmpty());
		assertNotNull(listVO.getPagingBean());
	}
	
	@Test
	public void getTotalMessageList() {
		String id="java";
		String pageNo="1";
		ListVO listVO=null;
		listVO=messageService.getTotalMessageList(id,null);
		assertFalse(listVO.getList().isEmpty());
		assertNotNull(listVO.getPagingBean());

		listVO=messageService.getTotalMessageList(id,pageNo);
		assertFalse(listVO.getList().isEmpty());
		assertNotNull(listVO.getPagingBean());
	}
	
	@Test
	public void detailMessage() {
		addMessage();
		MessageVO dbMessageVO=null;
		dbMessageVO=messageService.detailMessage(messageVO.getMessageNo(), "receive");
		assertEquals(messageVO.getTitle(), dbMessageVO.getTitle());
		assertEquals(messageVO.getMemberVO().getId(), dbMessageVO.getMemberVO().getId());
		assertEquals(true, dbMessageVO.isStatus());

		dbMessageVO=messageService.detailMessage(messageVO.getSendMessageNo(), "send");
		assertEquals(messageVO.getTitle(), dbMessageVO.getTitle());
		assertEquals(messageVO.getMemberVO().getId(), dbMessageVO.getMemberVO().getId());
		assertEquals(true, dbMessageVO.isReceiveFlag());
	}
	
	@Test
	public void deleteMessage() {
		addMessage();
		messageService.deleteMessage(messageVO.getSendMessageNo(), "send");
		assertNull(messageService.detailMessage(messageVO.getSendMessageNo(), "send"));
		messageService.deleteMessage(messageVO.getMessageNo(), "receive");
		assertNull(messageService.detailMessage(messageVO.getMessageNo(), "receive"));
	}
}
