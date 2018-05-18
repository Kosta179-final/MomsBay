package org.kosta.momsbay.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.momsbay.model.exception.LoginException;
import org.kosta.momsbay.model.service.MemberService;
import org.kosta.momsbay.model.vo.ChildrenVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * Member관련 mapping처리를 하는 controller.
 * ex)가입, 수정, 탈퇴
 * @author Hwang
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Member관련 요청 Mapping을 처리하는 컨트롤러
 * @author Hwang
 */
@RequestMapping("/member")
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
			requset.setAttribute("message", error.getMessage());
			return "member/login_fail";
		}
		
		if(member.getGrade().equals("blacklist")) {
			requset.setAttribute("message","차단된 회원입니다. 관리자에게 문의하세요.");
			return "member/login_fail";
		}
		
		member.setPassword("");
		member.setPoint(0);
		member.setChildren_no(member.getList().size());
		HttpSession session =requset.getSession();
		session.setAttribute("member", member);
		return "redirect:/home.do";
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
		return "redirect:/home.do";
	}
	
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName) {
		return "member/" + viewName + ".tiles";
	}
	
	/**
	 * id중복체크. ajax로 처리 flag 반환
	 * 
	 * @param id
	 * @param response
	 * @return flag
	 * @throws Exception
	 */
	@RequestMapping("idDuplicateCheck.do")
	public @ResponseBody Map<String, Boolean> idDuplicateCheck(@RequestParam(required = true) String id) {
		Map<String, Boolean> object = new HashMap<String, Boolean>();
		boolean flag = memberService.findMemberExsitById(id);
		object.put("duplicate", flag);
		return object;
	}

	/**
	 * email중복체크. ajax로 처리, flag 반환
	 * 
	 * @param email
	 * @param response
	 * @return flag
	 * @throws Exception
	 */
	@RequestMapping("mailDuplicateCheck.do")
	public @ResponseBody Map<String, Object> emailDuplicateCheck(@RequestParam(required = true) String email) {
		Map<String, Object> object = new HashMap<String, Object>();
		if (email.contains("@")) {
			boolean flag = memberService.findMemberByEmail(email);
			object.put("duplicate", flag);
			return object;
		} else {
			object.put("duplicate", "notEmail");
			return object;
		}
	}

	/**
	 * 회원가입 컨트롤러.
	 * 자식이 없을때 회원만 가입,
	 * 자식이 있으면 몇명인지 count 해서 별도로 transactional 처리.
	 * @param member
	 * @param year
	 * @param month
	 * @param day
	 * @param gender
	 * @param address2
	 * @return 주소URL
	 */
	@RequestMapping(method = RequestMethod.POST, value = "register.do")
	public String register(MemberVO member, String year, String month, String day, String gender, String address2) {
		/*
		 * 아이들 여럿이 들어왔을 때 처리하는 로직
		 * 아이가 하나도 없을때 처리하는 로직
		 */
		List<ChildrenVO> children = new ArrayList<ChildrenVO>();
		if(year!=null) {
			String[] birthYear = year.split(",");
			String[] birthMonth = month.split(",");
			String[] birthDay = day.split(",");
			String[] cGender = gender.split(",");
			for (int i = 0; i < birthYear.length; i++) {
				String birth = birthYear[i] + "." + birthMonth[i] + "." + birthDay[i];
				children.add(new ChildrenVO(cGender[i], birth));
			}
		}
		memberService.addMember(member, children);	
		return "redirect:register_succ.do";
	}
}
