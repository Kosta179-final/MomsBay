package org.kosta.momsbay.model.service;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.MessageMapper;
import org.kosta.momsbay.model.vo.MessageVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 쪽지 관련 서비스 제공.
 * 관련Mapper: MessageMapper
 * @author Hwang
 */
@Service
public class MessageService {
	@Resource
	MessageMapper messageMapper;
	
	@Transactional
	public void addMessage(MessageVO messageVO) {
		messageMapper.addReceiveMessage(messageVO);
		messageMapper.addSendMessage(messageVO);
	}
}
