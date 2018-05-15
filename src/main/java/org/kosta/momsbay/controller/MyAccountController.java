package org.kosta.momsbay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.momsbay.model.service.MemberService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 계정관련 작업 처리 Controller. ex)찜목록, 포인트충전, 거래내역 및 포인트 내역출력
 * 
 * @author Hwang
 */
@RequestMapping("/myaccount")
@Controller
public class MyAccountController {
	@Autowired
	MemberService memberService;

	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName) {
		return "service_myaccount" + ".page_" + viewName;
	}

	@RequestMapping(method=RequestMethod.POST,value="updateMember.do")
	public String update(MemberVO member, HttpServletRequest request) {
		memberService.updateMember(member);
		HttpSession session= request.getSession();
		session.setAttribute("member", member);
		return "redirect:myinfo_modify.do";
	}

	@RequestMapping(method=RequestMethod.POST,value="findMemberByPasswordAndId.do")
	public String findMemberByPasswordAndId(String id, String password) {		
		Boolean flag= memberService.findMemberByPasswordAndId(id,password);
		if(flag) {
			return "redirect:myinfo_modify.do";
		}else {
			return "redirect:access_deny.do";
		}	
	}
}