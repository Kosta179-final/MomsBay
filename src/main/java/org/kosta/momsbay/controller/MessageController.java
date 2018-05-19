package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.service.MessageService;
import org.kosta.momsbay.model.vo.MessageVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 쪽지 관련 작업처리 Controller.
 * @author Hwang
 */
@RequestMapping("/message")
@Controller
public class MessageController {
	@Resource
	MessageService messageService;
	/**
	 * 
	 * message와 관련된 tiles view를 보여준다.
	 * @param viewName
	 * @return message/{viewName}.m_tiles
	 */
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName) {
		return "message/"+viewName+".m_tiles";
	}
	
	/**
	 * 메세지 쓰기 form으로 가기위한 request처리
	 * @param receiveId
	 * @param model
	 * @return message/add_message_form.m_tiles
	 */
	@RequestMapping("/add_message_form.do")
	public String addMessageForm(String receiveId,Model model) {
		if(receiveId!=null)
			model.addAttribute("receiveId",receiveId);
		return "message/add_message_form.m_tiles";
	}
	
	/**
	 * 
	 * message를 추가하는 요청을 처리한다.
	 * @param messageVO
	 * @return redirect:message/list_receive_message.m_tiles 
	 * add를 마치면 받은메세지 함으로 redirect한다. 
	 */
	@RequestMapping("/add_message.do")
	public String addMessage(MessageVO messageVO) {
		messageService.addMessage(messageVO);
		return "redirect:getReceiveMessageList.do?receiveId="+messageVO.getMemberVO().getId();
	}
	/**	
	 * 검색 조건에 따라 받은 메세지목록을 보여준다.
	 * @param receiveId
	 * @param pageNo
	 * @param model
	 * @return message/list_receive_message.m_tiles
	 * 
	 */
	@RequestMapping("/getReceiveMessageList.do")
	public String getReceiveMessageList(String receiveId,String pageNo,Model model) {
		model.addAttribute("lvo",messageService.getReceiveMessageList(receiveId, pageNo));
		return "message/list_receive_message.m_tiles";
	}
}
