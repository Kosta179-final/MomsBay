package org.kosta.momsbay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.momsbay.model.exception.LoginException;
import org.kosta.momsbay.model.service.MemberService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
/**
 * Member관련 mapping처리를 하는 controller.
 * ex)가입, 수정, 탈퇴
 * @author Hwang
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(method=RequestMethod.POST,value="login.do")
	public String login(String id, String password, HttpServletRequest requset) {
		String userId= id.trim();
		String userPassword=password.trim();
		MemberVO member = new MemberVO();
		try {
			member = memberService.login(userId, userPassword);
		} catch (LoginException error) {
			// TODO Auto-generated catch block
			requset.setAttribute("message", error.getMessage());
			System.out.println(error.getMessage());
			return "member/login_fail";
		}
		member.setPassword("");
		HttpSession session =requset.getSession();
		session.setAttribute("member", member);
		return "redirect:home.do";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:home.do";
	}
}
