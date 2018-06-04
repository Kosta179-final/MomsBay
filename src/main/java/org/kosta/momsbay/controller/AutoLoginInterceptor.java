package org.kosta.momsbay.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.momsbay.model.service.MemberService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 컨트롤러 실행전 : preHandle(request,response,handler) 
 * 컨트롤러 실행후 : postHandle(request,response,handler)
 * 응답완료 : afterCompletion(request,response,handler)
 * 
 * Spring에서 제공하는 HandlerInterceptorAdapter 를 상속받아
 * 위와 같은 메서드를 오버라이딩해서 사용한다
 * @author Jung
 */
public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	@Resource
	private MemberService memberService;

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(session != null & memberVO != null) {
			return true;
		}
		Cookie[] cookie = request.getCookies();
		String mbId = null;
		String mbToken = null;
		if(cookie != null) {
			for(int i=0;i<cookie.length;i++) {
				if(cookie[i].getName().equals("mbId"))
					mbId = cookie[i].getValue();
				else if(cookie[i].getName().equals("mbToken"))
					mbToken = cookie[i].getValue();
			}
			if(mbId == null || mbToken == null)
				return true;
			if (memberService.autoLogin(mbId, mbToken)) {
				MemberVO member = memberService.findMemberById(mbId);
				member.setPassword("");
				member.setChildren_no(member.getList().size());
				session = request.getSession(true);
				session.setAttribute("member", member);

				String newToken = UUID.randomUUID().toString().substring(0, 10);
				Cookie idCookie = new Cookie("mbId", mbId);
				idCookie.setPath("/");
				Cookie tokenCookie = new Cookie("mbToken", newToken);
				tokenCookie.setPath("/");
				idCookie.setMaxAge(60 * 60 * 24 * 30);
				tokenCookie.setMaxAge(60 * 60 * 24 * 30);

				response.addCookie(idCookie);
				response.addCookie(tokenCookie);// 쿠키저장
				memberService.addAutoLoginToken(mbId, newToken);
			}
		}
		return true;
	}
}








