package org.kosta.momsbay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
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
		assertNotNull(messageMapper.getTotalReceiveMessageCount(receiveId));
	}
	/**
	 * 받은메세지를 가져온다.
	 */
	@Test
	public void getReceiveMessageList() {
		String receiveId="java";
		PagingBean pagingBean=new PagingBean(messageMapper.getTotalReceiveMessageCount(receiveId));
		Map map=new HashMap<String,Object>();
		map.put("receiveId", receiveId);
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getReceiveMessageList(map);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void getSendMessageList() {
		String sendId="sys";
		PagingBean pagingBean=new PagingBean(messageMapper.getTotalSendMessageCount(sendId));
		Map map=new HashMap<String,Object>();
		map.put("sendId", sendId);
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getSendMessageList(map);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void getTotalMessageList() {
		String id="sys";
		PagingBean pagingBean=new PagingBean(messageMapper.getTotalReceiveMessageCount(id)+messageMapper.getTotalSendMessageCount(id));
		Map map=new HashMap<String,Object>();
		map.put("id", id);
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
}
