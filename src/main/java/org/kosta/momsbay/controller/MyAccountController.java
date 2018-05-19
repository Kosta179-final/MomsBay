package org.kosta.momsbay.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.momsbay.model.service.HistoryService;
import org.kosta.momsbay.model.service.MemberPickService;
import org.kosta.momsbay.model.service.MemberService;
import org.kosta.momsbay.model.service.PointService;
import org.kosta.momsbay.model.service.TradePostService;
import org.kosta.momsbay.model.vo.MemberPickVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	@Autowired
	HistoryService historyService;
	@Autowired
	PointService pointService;
	@Autowired
	TradePostService tradePostService;
	@Autowired
	MemberPickService memberPickService;

	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName) {
		return "service_myaccount" + ".page_" + viewName;
	}

	/**
	 * 회원정보수정.
	 * 
	 * @param member
	 * @param request
	 * @return url
	 * @author Hwang
	 */
	@RequestMapping(method = RequestMethod.POST, value = "updateMember.do")
	public String update(MemberVO member, HttpServletRequest request) {
		memberService.updateMember(member);
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		return "redirect:modify_myinfo.do";
	}

	/**
	 * 비밀번호 확인으로 접근제어.
	 * 
	 * @param id
	 * @param password
	 * @return url
	 * @author Hwang
	 */
	@RequestMapping(method = RequestMethod.POST, value = "findMemberByPasswordAndId.do")
	public String findMemberByPasswordAndId(String id, String password) {
		Boolean flag = memberService.findMemberByPasswordAndId(id, password);
		if (flag) {
			return "redirect:modify_myinfo.do";
		} else {
			return "redirect:access_deny.do";
		}
	}

	/**
	 * 포인트 내역 조회.
	 * 
	 * @param request
	 * @return url
	 * @author Hwang
	 */
	@RequestMapping("getPointHistoryById.do")
	public String getPointHistoryById(HttpServletRequest request, String pageNo) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		request.setAttribute("pointHistory", historyService.getPointHistoryById(member.getId(), pageNo));
		return "service_myaccount" + ".page_" + "show_point_history";
	}
	
	@RequestMapping("getPointHistoryByIdAndDate.do")
	public String getPointHistoryById(HttpServletRequest request, String pageNo, String startDate, String endDate) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		request.setAttribute("pointHistory", historyService.getPointHistoryByIdAndDate(member.getId(), pageNo, startDate, endDate));
		return "service_myaccount" + ".page_" + "show_point_history";
	}

	/**
	 * 포인트 충전. 포인트 충전과 내역남기기는 동시에 이루어진다. 고로 트랜젝셔널 처리. 실패 시 실패 메시지를 던진다. 성공 시 성공 메시지를
	 * 던진다.
	 * 
	 * @param request
	 * @param point
	 * @return url과 메시지
	 * @author Hwang
	 */
	@Transactional
	@SuppressWarnings("finally")
	@RequestMapping("chargePoint.do")
	public String chargePoint(HttpServletRequest request, String point) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String msg = "";
		try {
			String id = member.getId();
			pointService.updateChargePoint(id, point);
			historyService.addPointChargeHistory(id, point);
			msg = "success!";
		} catch (Exception e) {
			msg = "fail try again";
		} finally {
			return "redirect:charge_point_status.do?message=" + msg;
		}
	}

	/**
	 * 포인트 조회.
	 * 
	 * @param request
	 * @return url
	 * @author Hwang
	 */
	@RequestMapping("findNowpointById.do")
	public String findNowpointById(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String id = member.getId();
		String point = pointService.findNowpointById(id);
		session.setAttribute("point", point);
		return "service_myaccount" + ".page_" + "service_point";
	}
	
	/**
	 * 찜 내역 조회.
	 * 
	 * @param request
	 * @return url
	 * @author Jung
	 */
	@RequestMapping("getPickListById.do")
	public String getPickListById(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		List<TradePostVO> list = tradePostService.findPickListById(member.getId());
		request.setAttribute("list", list);
		return "service_myaccount" + ".page_" + "list_pick";
	}
	
	/**
	 * 찜 삭제
	 * @param request
	 * @param memberPickVO
	 * @return url
	 * @author Jung
	 */
	@RequestMapping("deleteMemberPick.do")
	public String deleteMemberPick(HttpServletRequest request,MemberPickVO memberPickVO) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		memberPickVO.setId(member.getId());
		memberPickService.deleteMemberPick(memberPickVO);
		return "redirect:getPickListById.do";
	}
	
	
	/**
	 * 찜 추가
	 * @param request
	 * @param memberPickVO
	 * @return url
	 * @author Jung
	 */
	@RequestMapping("addMemberPick.do")
	public String addMemberPick(HttpServletRequest request,MemberPickVO memberPickVO) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		memberPickVO.setId(member.getId());
		memberPickService.addMemberPick(memberPickVO);
		return "redirect:getPickListById.do";
	}
	
	@Transactional
	@RequestMapping("exchangePoint.do")
	public String exchangePoint(HttpServletRequest request, String password, String exchangePoint) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String id = member.getId();
		String msg = "";
		/*
		 * 비밀번호 체크 후 ->환전 후->내역남기기
		 */
		if (memberService.findMemberByPasswordAndId(id, password)) {
			try {
				pointService.updateExchangePoint(id, exchangePoint);
				historyService.addPointExchangeHistory(id, exchangePoint);
				msg= "Exchange Success!";
			} catch (Exception e) {
				msg = "Exchange Error! Try Again";
			}
		} else {
			/* 비밀번호가 틀렸으니 쫒아낸다. */
			msg = "password error! Try Again";
		}
		String point = pointService.findNowpointById(id);
		session.setAttribute("point", point);
		return "redirect:charge_point_status.do?message=" + msg;
	}
}