package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.CommentService;
<<<<<<< HEAD
import org.kosta.momsbay.model.service.TradePostService;
=======
import org.kosta.momsbay.model.service.SharePostService;
import org.kosta.momsbay.model.vo.SharePostVO;
>>>>>>> branch 'master' of https://github.com/KostaFinal2ZO/MomsBay.git
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
	@Resource
	private SharePostService sharePostService;
	
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName, String boardTypeNo,String pageNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("listVO", tradePostService.getTradePostList(pageNo));
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
