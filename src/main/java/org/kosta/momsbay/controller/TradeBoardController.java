package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.CommentService;
import org.kosta.momsbay.model.service.TradePostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TradePost 처리하는 Controller.
 * 관련Service: TradeService, BayPostService, TradePostService
 * @author Hwang
 *
 */
@RequestMapping("/trade")
@Controller
public class TradeBoardController {
	@Resource
	private CommentService commentService;
	@Resource
	private TradePostService tradePostService;
	
	/**
	 * 중고거래 게시판 클릭시 실행되는 메서드.
	 * @param viewName righ
	 * @param boardTypeNo
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName, String boardTypeNo,String pageNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("listVO", tradePostService.getTradePostList(pageNo));
		return "service_trade" + ".page_" + viewName;
	}
}
