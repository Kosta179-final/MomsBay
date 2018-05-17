package org.kosta.momsbay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.kosta.momsbay.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 관리자 기능 수행하는 컨트롤러.
 * @author Hwang
 */
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName) {
		return "service_admin" + ".page_" + viewName;
	}
	
	/**
	 * 회원 리스트를 조회하는 메소드.
	 * @param request
	 * @return url
	 * @author Hwang
	 */
	@RequestMapping("getPeopleList.do")
	public String getPeopleList(HttpServletRequest request) {
		request.setAttribute("memberList", memberService.getMemberList(1));
		request.setAttribute("blackList",memberService.getMemberList(3));
		return "service_admin" + ".page_management_member";
	}
	
	/**
	 * 멤버등급 변경하는 메소드.
	 * @param id
	 * @return 회원변경 타입
	 * @author Hwang
	 */
	@RequestMapping("updateMemberStatus.do")
	public @ResponseBody Map<String, String> updateMemberStatus(@RequestParam(required = true) String id) {
		Map<String, String> map = new HashMap<String, String>();
		String status = memberService.updateMemberStatus(id);
		map.put("status", status);
		return map;
	}
}
