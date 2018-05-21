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
		messageMapper.addSendMessage(messageVO);
		messageMapper.addReceiveMessage(messageVO);
	}
	/**
	 * 받은 메세지 목록을 가져온다.
	 * @param receiveId
	 * @param pageNo
	 * @return receiveMessage list와 pagingBean을 가진 ListVO
	 */
	public ListVO getReceiveMessageList(String receiveId,String pageNo){
		PagingBean pagingBean=null;
		if(pageNo==null) {
			pagingBean=new PagingBean(messageMapper.getTotalReceiveMessageCount(receiveId));
		} else {
			pagingBean=new PagingBean(messageMapper.getTotalReceiveMessageCount(receiveId),Integer.parseInt(pageNo));
		}
		Map<String,Object> map=new HashMap<>();
		map.put("receiveId", receiveId);
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getReceiveMessageList(map);
		return new ListVO(list,pagingBean);
	}
	
	/**
	 * 보낸 메세지 목록을 가져온다.
	 * @param sendId
	 * @param pageNo
	 * @return sendMessage list와 pagingBean을 가진 ListVO
	 */
	public ListVO getSendMessageList(String sendId,String pageNo){
		PagingBean pagingBean=null;
		if(pageNo==null) {
			pagingBean=new PagingBean(messageMapper.getTotalSendMessageCount(sendId));
		} else {
			pagingBean=new PagingBean(messageMapper.getTotalSendMessageCount(sendId),Integer.parseInt(pageNo));
		}
		Map<String,Object> map=new HashMap<>();
		map.put("sendId",sendId);
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getSendMessageList(map);
		return new ListVO(list,pagingBean);
	}
	public ListVO getTotalMessageList(String id, String pageNo) {
		PagingBean pagingBean=null;
		int totalCount=messageMapper.getTotalSendMessageCount(id)+messageMapper.getTotalReceiveMessageCount(id);
		if(pageNo==null) {
			pagingBean=new PagingBean(totalCount);
		} else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
		}
		Map<String,Object> map=new HashMap<>();
		map.put("id",id);
		map.put("pagingBean", pagingBean);
		List<PostVO> list=messageMapper.getTotalMessageList(map);
		return new ListVO(list,pagingBean);
	}
}
