package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.MessageMapper;
import org.kosta.momsbay.model.vo.MessageVO;
import org.kosta.momsbay.model.vo.PostVO;
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
	/**
	 * 쪽지쓰기로 보낸 메세지정보를 receive와 send에 각각 저장한다.
	 * @param messageVO
	 */
	@Transactional
	public void addMessage(MessageVO messageVO) {
		messageMapper.addReceiveMessage(messageVO);
		messageMapper.addSendMessage(messageVO);
	}
	/**
	 * 받은 메세지 목록을 가져온다.
	 * @param receiveId
	 * @param pageNo
	 * @return
	 */
	public ListVO getReceiveMessageList(String receiveId,String pageNo){
		PagingBean pagingBean=null;
		if(pageNo==null) {
			pagingBean=new PagingBean(messageMapper.getTotalMessageCount(receiveId));
		} else {
			pagingBean=new PagingBean(messageMapper.getTotalMessageCount(receiveId),Integer.parseInt(pageNo));
		}
		Map map=new HashMap<String,Object>();
		map.put("receiveId", receiveId);
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getReceiveMessageList(map);
		return new ListVO(list,pagingBean);
	}
}
