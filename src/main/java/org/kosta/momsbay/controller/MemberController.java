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
/**
 * Member관련 요청 Mapping을 처리하는 컨트롤러
 * @author Hwang
 */
@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	/**
	 * 로그인처리.
	 * id와 password를 trim처리.
	 * Service에서 에러 발생시 LoginException의 메세지를 parameter로 전달.
	 * Alert로 띄워준다.
	 * @param id
	 * @param password
	 * @param requset
	 * @return 화면에 보여 줄 View Path
	 */
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
	
	/**
	 * 로그아웃.
	 * Detail.세션을 만료시킨다.
	 * @param request
	 * @return Home View
	 */
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:home.do";
	}
}
