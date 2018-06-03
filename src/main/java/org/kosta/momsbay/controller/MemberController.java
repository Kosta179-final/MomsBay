package org.kosta.momsbay.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.momsbay.model.exception.LoginException;
import org.kosta.momsbay.model.exception.NoMemberFoundException;
import org.kosta.momsbay.model.service.MemberService;
import org.kosta.momsbay.model.service.RatingService;
import org.kosta.momsbay.model.vo.ChildrenVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Member관련 요청 Mapping을 처리하는 컨트롤러
 * 
 * @author 개발제발
 */
@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	RatingService ratingService;

	/**
	 * 로그인처리. id와 password를 trim처리. Service에서 에러 발생시 LoginException의 메세지를 parameter로
	 * 전달. Alert로 띄워준다.
	 * 
	 * @param id
	 * @param password
	 * @param requset
	 * @return 화면에 보여 줄 View Path
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "login.do")
	public void login(String id, String password, String rememberMe, HttpServletRequest requset,
			HttpServletResponse response) throws IOException {
		String userId = id.trim();
		String userPassword = password.trim();
		MemberVO member = new MemberVO();
		try {
			member = memberService.login(userId, userPassword);
			if (member.getGrade() != null && member.getGrade().equals("blacklist")) {
				response.sendRedirect(
						"system_paramAlert.do?message=" + "Your bolcked by Admin/nContect To Mom'sbay");
			} else {
				member.setPassword("");
				member.setChildren_no(member.getList().size());

				HttpSession session = requset.getSession();
				session.setAttribute("member", member);
				if (rememberMe.equals("true")) {
					/*
					 * 쿠키와 db에 자동로그인 정보 저장하기
					 */
					String token = UUID.randomUUID().toString().substring(0, 10);
					Cookie idCookie = new Cookie("mbId", member.getId());
					Cookie tokenCookie = new Cookie("mbToken", token);
					idCookie.setPath("/");
					tokenCookie.setPath("/");
					idCookie.setMaxAge(60 * 60 * 24 * 30);
					tokenCookie.setMaxAge(60 * 60 * 24 * 30);

					response.addCookie(idCookie); // 쿠키저장
					response.addCookie(tokenCookie);
					makeTokenCookie(id, token);
					response.sendRedirect("/momsbay/home.do");
				}else {
					response.sendRedirect("/momsbay/home.do");
				}
			}
		} catch (LoginException error) {
			response.sendRedirect("system_paramAlert.do?message=" + error.getMessage());
		}
	}

	/**
	 * 자동로그인 보안유지를 위한 임시토큰을 데이터베이스에 업데이트한다.
	 * 
	 * @param cookieName
	 * @return
	 */
	public void makeTokenCookie(String id, String token) {
		memberService.addAutoLoginToken(id, token);
	}

	@RequestMapping("autoLogin.do")
	public void autoLogin(HttpServletRequest request, HttpServletResponse response, String id, String token) {
		String message = "";
		try {
			if (memberService.autoLogin(id, token)) {
				MemberVO member = memberService.findMemberById(id);
				member.setPassword("");
				member.setChildren_no(member.getList().size());
				HttpSession session = request.getSession();
				session.setAttribute("member", member);

				String newToken = UUID.randomUUID().toString().substring(0, 10);
				Cookie idCookie = new Cookie("mbId", id);
				idCookie.setPath("/");
				Cookie tokenCookie = new Cookie("mbToken", newToken);
				tokenCookie.setPath("/");
				idCookie.setMaxAge(60 * 60 * 24 * 30);
				tokenCookie.setMaxAge(60 * 60 * 24 * 30);

				response.addCookie(idCookie);
				response.addCookie(tokenCookie);// 쿠키저장
				makeTokenCookie(id, newToken);
				response.sendRedirect("system_alert_home.do?message=" + "Auto Login Succ");
			} else {
				/*
				 * 토큰값이 일치하지 않으면 무단접속으로 간주하고 기존 쿠키를 전부 삭제.
				 */
				Cookie idCookie = new Cookie("mbId", null);
				idCookie.setPath("/");
				Cookie tokenCookie = new Cookie("mbToken", null);
				tokenCookie.setPath("/");
				response.addCookie(idCookie);
				response.addCookie(tokenCookie); // 기존의 쿠키 삭제
				/* db에서도 삭제한다. */
				memberService.deleteTokenById(id);
				message = "Someone AutoLogin on other conputer.\n Please check your account";
				response.sendRedirect("system_alert_home.do?message=" + message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 로그아웃. Detail.세션을 만료시킨다.
	 * 
	 * @param request
	 * @return Home View
	 * @throws IOException
	 */
	@RequestMapping("logout.do")
	public void logout(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
		HttpSession session = request.getSession();
		Cookie idCookie = new Cookie("mbId", null);
		idCookie.setPath("/");
		Cookie tokenCookie = new Cookie("mbToken", null);
		tokenCookie.setPath("/");
		idCookie.setMaxAge(60 * 60 * 24 * 30);
		tokenCookie.setMaxAge(60 * 60 * 24 * 30);

		response.addCookie(idCookie);
		response.addCookie(tokenCookie); // 기존의 쿠키 삭제
		/* db에서도 삭제한다. */
		memberService.deleteTokenById(id);
		session.invalidate();
		response.sendRedirect("/momsbay/home.do");
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
	 * 회원가입 컨트롤러. 자식이 없을때 회원만 가입, 자식이 있으면 몇명인지 count 해서 별도로 transactional 처리.
	 * 
	 * @param member
	 * @param year
	 * @param month
	 * @param day
	 * @param gender
	 * @param address2
	 * @return 주소URL
	 */
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "register.do")
	public String register(MemberVO member, String year, String month, String day, String gender, String address2) {
		/*
		 * 아이들 여럿이 들어왔을 때 처리하는 로직 아이가 하나도 없을때 처리하는 로직
		 */
		List<ChildrenVO> children = new ArrayList<ChildrenVO>();
		if (year != null) {
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
		ratingService.createRating(member.getId());

		return "redirect:register_succ.do";
	}

	/**
	 * 비밀번호 찾기 메소드. 입력한 이름과 이메일주소가 db값과 일치하면 등록되어있는 메일로 임시 비밀번호를 보내고, db의 값으로
	 * update한다.
	 * 
	 * @param member
	 * @param request
	 * @return 메시지
	 * @author Hwang
	 */
	@RequestMapping(method = RequestMethod.POST, value = "findPasswordByNameAndEmail.do")
	public String findPasswordByNameAndEmail(MemberVO member, HttpServletRequest request) {
		String message = "";
		try {
			memberService.findPasswordByNameAndEmail(member);
		} catch (NoMemberFoundException e) {
			// TODO: handle exception
			message = e.getMessage();
			return "redirect:/member/system_paramAlert.do?message=" + message;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = "DB ERROR!\n Try Again";
			return "redirect:/member/system_paramAlert.do?message=" + message;
		} catch (IOException e) {
			message = e.getMessage();
		}
		message = "We Send Temp password to Your Email\nPlease Check Email";
		return "redirect:/member/system_paramAlert.do?message=" + message;
	}
}
