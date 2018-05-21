package org.kosta.momsbay.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.kosta.momsbay.model.service.MemberService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 관리자 기능 수행하는 컨트롤러.
 * 
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
	 * 
	 * @param request
	 * @return url
	 * @author Hwang
	 */
	@RequestMapping("getPeopleList.do")
	public String getPeopleList(HttpServletRequest request) {
		request.setAttribute("memberList", memberService.getMemberList(1));
		request.setAttribute("blackList", memberService.getMemberList(3));
		return "service_admin" + ".page_management_member";
	}

	/**
	 * 멤버등급 변경하는 메소드.
	 * 
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

	/**
	 * 아이디로 검색 시 자동완성으로 리스트 제공.
	 * @param term
	 * @return ajax로 검색결과 리스트 반환.
	 * @author Hwang
	 */
	@RequestMapping("searchMemberById.do")
	public @ResponseBody List<String> searchMemberById(@RequestParam(required = true) String term) {
		List<String> memberList = new ArrayList<String>();
		memberList = memberService.findMemberIdByPart(term);
		return memberList;
	}

	/**
	 * 아이디 검색 시 해당 회원 상세정보 제공.
	 * @param id
	 * @return 회원정보.
	 * @author Hwang
	 */
	@RequestMapping("findMemberById.do")
	public @ResponseBody MemberVO findMemberById(@RequestParam(required = true) String id) {
		MemberVO searchMember = new MemberVO();
		searchMember = memberService.findMemberById(id);
		return searchMember;
	}

	/**
	 * 검색된 회원의 회원등급을 바꿔주는 메소드. 
	 * @param id
	 * @return 회원등급 수정 결과 메시지.
	 * @author Hwang
	 */
	@RequestMapping(method = RequestMethod.POST, value = "updateMemberStatusOnSubmit.do")
	public String updateMemberStatusOnSubmit(String id) {
		String msg="change grade succ";
		try {
			memberService.updateMemberStatus(id);
		} catch (Exception e) {
			msg="change grade fail";
		}
		return "redirect:update_status_alert.do?message="+msg;
	}
	
	/**
	 * 구글 차트를 활용해 통계자료를 json으로 반환한다.
	 * @return list
	 */
	@RequestMapping("getStatistics.do")
	public String getStatistics(HttpServletRequest request){
		/*
		 * 제이슨 형식으로 보내긴 해야되는데 
		 * 중괄호가 자꾸 껴서 스트링 빌더로 알아서 조합해서
		 * 파스함.
		 */
		request.setAttribute("statistics_ofChildren", memberService.getMemberChildStatistics());
		/*
		 * 회원 등급 별 통계
		 * 나중에는 글 많이 쓴 사람 5명정도 뽑아서 통계내도 될듯
		 */
		request.setAttribute("statistics_ofGrade", memberService.getMemberGradeStatistics());
		/*
		 * 회원 자녀 나이대별 통계
		 */
		request.setAttribute("statistics_ofChildrenAge", memberService.getChildrenAgeStatistics());
		return "service_admin" + ".page_show_statistics";
	}
}
