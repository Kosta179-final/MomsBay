package org.kosta.momsbay;

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
	 * 메세지 수신 데이터를 db에 추가한다.
	 */
	@Test
	public void addReceiveMessage() {
		MessageVO messageVO=new MessageVO();
		messageVO.setTitle("test");
		messageVO.setContent("testing");
		messageVO.setMemberVO(new MemberVO());
		messageVO.getMemberVO().setId("sys");
		messageVO.setReceiveMemberVO(new MemberVO());
		messageVO.getReceiveMemberVO().setId("java");
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
		messageVO.setReceiveMemberVO(new MemberVO());
		messageVO.getReceiveMemberVO().setId("java");
		messageMapper.addSendMessage(messageVO);
	}
	/**
	 * 메세지의 총갯수를 가져온다.
	 */
	@Test
	public void getTotalMessageCount() {
		String receiveId="java";
		assertNotNull(messageMapper.getTotalMessageCount(receiveId));
	}
	/**
	 * 받은메세지를 가져온다.
	 */
	@Test
	public void getReceiveMessageList() {
		String receiveId="java";
		PagingBean pagingBean=new PagingBean(messageMapper.getTotalMessageCount(receiveId));
		Map map=new HashMap<String,Object>();
		map.put("receiveId", receiveId);
		map.put("pagingBean", pagingBean);
		assertNotNull(messageMapper.getReceiveMessageList(map));
	}
}
