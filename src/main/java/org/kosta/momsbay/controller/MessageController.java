package org.kosta.momsbay.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.service.MessageService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.MessageVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "redirect:getReceiveMessageList.do?id="+messageVO.getMemberVO().getId();
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
	public String getReceiveMessageList(String id,String pageNo,String status,Model model) {
		model.addAttribute("lvo",messageService.getReceiveMessageList(id, pageNo,null));
		return "message/list_receive_message.m_tiles";
	}
	/**
	 * 보낸 메세지 목록을 Ajax로 응답한다.
	 * @param receiveId
	 * @param status
	 * @return List<PostVO>
	 */
	@RequestMapping("/getReceiveMessageListAPI.do")
	@ResponseBody
	public Map<String,Object> getReceiveMessageList(String receiveId,String status) {
		ListVO listVO=messageService.getReceiveMessageList(receiveId, null,status);
		Map<String,Object> map=new HashMap<>();
		map.put("count", listVO.getPagingBean().getTotalPostCount());
		map.put("list", listVO.getList());
		return map;
	}
	/**
	 * 검색 조건에 따라 보낸 메세지목록을 보여준다.
	 * @param sendId
	 * @param pageNo
	 * @param model
	 * @return message/list_send_message.m_tiles
	 */
	@RequestMapping("/getSendMessageList.do")
	public String getSendMessageList(String id,String pageNo,String status,Model model) {
		model.addAttribute("lvo",messageService.getSendMessageList(id, pageNo));
		return "message/list_send_message.m_tiles";
	}
	
	/**
	 * 검색조건에 따라 전체 메세지 목록을 보여준다.
	 * @param id
	 * @param pageNo
	 * @param model
	 * @return message/list_total_message.m_tiles
	 */
	@RequestMapping("getTotalMessageList.do")
	public String getTotalMessageList(String id,String pageNo,String status,Model model) {
		model.addAttribute("lvo", messageService.getTotalMessageList(id, pageNo));
		return "message/list_total_message.m_tiles";
	}
	/**
	 * 같이 넘어온 messageType에 따라 메세지 내용을 type에 맞는 table에서 가져와 보여준다.
	 * @param messageNo
	 * @param messageType
	 * @param model
	 * @return message/detail_message.m_tiles
	 */
	@RequestMapping("detail_message.do")
	public String detailMessage(int messageNo,String messageType,String status,Model model) {
		System.out.println("test1 "+ messageType.substring(messageType.indexOf("_")+1));
		messageType=messageType.substring(messageType.indexOf("_")+1);
		model.addAttribute("messageVO",messageService.detailMessage(messageNo,messageType));
		return "message/detail_message.m_tiles";
	}
	
	/**
	 * 같이 넘어온 메세지 타입에 따라 table에서 해당 메세지 번호를 삭제한다.
	 * @param messageNo
	 * @param messageType
	 * @param request
	 * @return url 메세지 타입에 따라 목록으로 돌아간다.
	 */
	@RequestMapping("delete_message.do")
	public String deleteMessage(int messageNo,String messageType,int pageNo,String status,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		messageService.deleteMessage(messageNo, messageType.substring(messageType.indexOf("_")+1));
		String url=null;
		if(messageType.equals("receive")){
			url="redirect:getReceiveMessageList.do?";	
		} else if(messageType.equals("send")){
			url="redirect:getSendMessageList.do?";
		} else {
			url="redirect:getTotalMessageList.do?";
		}
		url+="id="+memberVO.getId();
		url+="&pageNo="+pageNo;
		if(status!=null) {
			url+="&status="+status;
		}
		
		return url;
	}
}
