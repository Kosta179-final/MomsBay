package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.CommentService;
import org.kosta.momsbay.model.service.SharePostService;
import org.kosta.momsbay.model.vo.SharePostVO;
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
	private SharePostService sharePostService;
	
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName, String boardTypeNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		return "service_trade" + ".page_" + viewName;
	}
	
	/**
	 * 나눔 게시판 글쓰기
	 * @param tradePostVO
	 * @return 나눔 게시판 List
	 */
	@RequestMapping("shareWrite.do")
	public String shareWrite(SharePostVO sharePostVO) {
		sharePostService.addSharePost(sharePostVO);
		return "redirect:share_list.do";
	}
}
