package org.kosta.momsbay;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
	
	/**
	 * 메세지 수신을 저장하기 위해서는 FK를 저장하기 위해 발신을  먼저 추가 하고 추가한다.
	 */
	@Test
	public void addReceiveMessage() {
		MessageVO sendMessageVO=new MessageVO();
		sendMessageVO.setTitle("test");
		sendMessageVO.setContent("testing");
		sendMessageVO.setMemberVO(new MemberVO());
		sendMessageVO.getMemberVO().setId("sys");
		sendMessageVO.setReceiveMemberVO(new MemberVO());
		sendMessageVO.getReceiveMemberVO().setId("java");
		messageMapper.addSendMessage(sendMessageVO);

		MessageVO receiveMessageVO=new MessageVO();
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
	 * 발신메세지를 저장하는 테스트 코드
	 */
	@Test
	public void addSendMessage() {
		MessageVO sendMessageVO=new MessageVO();
		sendMessageVO.setTitle("test");
		sendMessageVO.setContent("testing");
		sendMessageVO.setMemberVO(new MemberVO());
		sendMessageVO.getMemberVO().setId("sys");
		sendMessageVO.setReceiveMemberVO(new MemberVO());
		sendMessageVO.getReceiveMemberVO().setId("java");
		messageMapper.addSendMessage(sendMessageVO);
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
}
