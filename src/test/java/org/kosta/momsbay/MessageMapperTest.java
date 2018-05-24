package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.MessageMapper;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.MessageVO;
import org.kosta.momsbay.model.vo.PostVO;
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
	MessageVO sendMessageVO;
	MessageVO receiveMessageVO;
	
	/**
	 * 메세지 수신을 저장하기 위해서는 FK를 저장하기 위해 발신을  먼저 추가 하고 추가한다.
	 */
	@Test
	public void addMessage() {
		sendMessageVO=new MessageVO();
		sendMessageVO.setTitle("test");
		sendMessageVO.setContent("testing");
		sendMessageVO.setMemberVO(new MemberVO());
		sendMessageVO.getMemberVO().setId("sys");
		sendMessageVO.setReceiveMemberVO(new MemberVO());
		sendMessageVO.getReceiveMemberVO().setId("java");
		messageMapper.addSendMessage(sendMessageVO);

		receiveMessageVO=new MessageVO();
		receiveMessageVO.setTitle("test");
		receiveMessageVO.setContent("testing");	
		receiveMessageVO.setMemberVO(new MemberVO());
		receiveMessageVO.getMemberVO().setId("sys");
		receiveMessageVO.setReceiveMemberVO(new MemberVO());
		receiveMessageVO.getReceiveMemberVO().setId("java");
		receiveMessageVO.setSendMessageNo(sendMessageVO.getSendMessageNo());
		messageMapper.addReceiveMessage(receiveMessageVO);
		
	}
	
	/**
	 * 메세지의 총갯수를 가져온다.
	 */
	@Test
	public void getTotalReceiveMessageCount() {
		String receiveId="java";
		String status="0";
		Map<String,Object> map=new HashMap<>();
		map.put("id", receiveId);
		map.put("status", status);
		assertNotNull(messageMapper.getTotalReceiveMessageCount(map));
	}
	/**
	 * 받은메세지를 가져온다.
	 */
	@Test
	public void getReceiveMessageList() {
		String receiveId="java";
		String status="0";
		Map<String,Object> map=new HashMap<>();
		map.put("id", receiveId);
		map.put("requestStatus", status);
		PagingBean pagingBean=new PagingBean(messageMapper.getTotalReceiveMessageCount(map));
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getReceiveMessageList(map);
		assertFalse(list.isEmpty());
		
		Map<String,Object> map2=new HashMap<>();
		map2.put("id", receiveId);
		map2.put("requestStatus",status);
		List<PostVO> list2=messageMapper.getReceiveMessageList(map2);
		assertFalse(list2.isEmpty());
		
		Map<String,Object> map3=new HashMap<>();
		map3.put("id", receiveId);
		map3.put("requestStatus",status);
		map3.put("pagingBean", pagingBean);
		List<PostVO> list3=messageMapper.getReceiveMessageList(map3);
		assertFalse(list3.isEmpty());
	}
	
	@Test
	public void getSendMessageList() {
		String sendId="sys";
		Map map=new HashMap<String,Object>();
		map.put("id", sendId);
		PagingBean pagingBean=new PagingBean(messageMapper.getTotalSendMessageCount(map));
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getSendMessageList(map);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void getTotalMessageList() {
		String id="sys";
		String requestStatus="0";
		Map map=new HashMap<String,Object>();
		map.put("id", id);
		PagingBean pagingBean=new PagingBean(messageMapper.getTotalReceiveMessageCount(map)+messageMapper.getTotalSendMessageCount(map));
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getTotalMessageList(map);
		assertFalse(list.isEmpty());
	}
	/**
	 * 메세지 정보를 가져오기 위해 먼저 메세지를 추가하고 정보를 조회한다.
	 * messageType에 가져오려고 하는 메세지 타입을 넣어 dynamic sql을 실행한다.
	 */
	@Test
	public void detailMessage() {
		addMessage();
		Map<String,Object> map=new HashMap<>();
		map.put("messageNo", sendMessageVO.getSendMessageNo());
		map.put("messageType", "send");
		MessageVO dbMessageVO=messageMapper.detailMessage(map);
		assertEquals(sendMessageVO.getTitle(), dbMessageVO.getTitle());
		assertEquals(sendMessageVO.getMemberVO().getId(), dbMessageVO.getMemberVO().getId());
	}
	
	@Test
	public void updateReceiveFlag() {
		addMessage();
		messageMapper.updateReceiveFlag(receiveMessageVO.getSendMessageNo());
		
	}
	
	@Test 
	public void updateStatus() {
		addMessage();
		messageMapper.updateStatus(receiveMessageVO.getMessageNo());
	}
	
	@Test
	public void deleteMessage() {
		addMessage();
		Map<String,Object> map=new HashMap<>();
		map.put("messageNo", sendMessageVO.getSendMessageNo());
		map.put("messageType", "send");
		messageMapper.deleteMessage(map);
		assertNull(messageMapper.detailMessage(map));
		
		map.put("messageNo", receiveMessageVO.getMessageNo());
		map.put("messageType", "receive");
		messageMapper.deleteMessage(map);
		assertNull(messageMapper.detailMessage(map));
	}
	
}
