package org.kosta.momsbay.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.momsbay.model.service.TradePostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Home으로 mapping과 PathVariable을 통해 페이지이동을 담당하는 컨트롤러.
 * @author 개발제발
 *
 */
@Controller
public class HomeController {
	/*기존 홈 메서드 사용안함*/
	/*@RequestMapping("home.do")
	public String home() {
		return "home.tiles";
	}*/
	
	
	@Resource
	private TradePostService tradePostService;
	/**
	 * 새로운 홈화면으로 가기(삽니다 팝니다 게시글 최근순으로 3개 표시)
	 * @param tradePostNo
	 * @param model
	 * @return home
	 * @author rws
	 */
	@RequestMapping("home.do")
	public String listMainTradePostTiles(String tradePostNo, Model model) {
		model.addAttribute("tradePostNo", tradePostNo);
		model.addAttribute("mainList", tradePostService.getMainTradePostList());
		return "home.tiles";
	}
	
	@RequestMapping("authorization.do")
	public String authorization(HttpServletRequest request) {
		request.setAttribute("message","접근 권한이 없습니다.");
		return "member/admin_authorization";
	}
}
