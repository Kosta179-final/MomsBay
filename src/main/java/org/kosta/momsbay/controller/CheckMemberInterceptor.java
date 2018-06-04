package org.kosta.momsbay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class CheckMemberInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(session != null && memberVO != null) {
			if(memberVO.getGrade().equals("blacklist")) {
				response.sendRedirect("../home.do");
				return false;
			}
			else 
				return true;
		}
		else {
			response.sendRedirect("../home.do");
			return false;
		}
	}
}








