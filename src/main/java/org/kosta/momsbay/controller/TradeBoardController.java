package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.CommentService;
import org.kosta.momsbay.model.service.SharePostService;
import org.kosta.momsbay.model.service.TradePostService;
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
	private TradePostService tradePostService;
	@Resource
	private SharePostService sharePostService;
	
	/**
	 * 중고거래 게시판 클릭시 실행되는 메서드.
	 * @param viewName righ
	 * @param boardTypeNo
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName, String boardTypeNo, Model model, String pageNo) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		if(boardTypeNo.equals("1") || boardTypeNo.equals("2")) {
			model.addAttribute("listVO", tradePostService.getTradePostList(pageNo));			
		} else if(boardTypeNo.equals("3") || boardTypeNo.equals("4")) {
			model.addAttribute("svo", sharePostService.getSharePostList(pageNo));
		}
		return "service_trade" + ".page_" + viewName;
	}
	
	/**
	 * 나눔게시판 상세보기 메서드
	 * @return service_trade.page_detail_share_post
	 */
	@RequestMapping("/detail_share_post.do")
	public String findDetailSharePost(String noneTradePostNo, Model model) {
		model.addAttribute("pvo", sharePostService.findDetailSharePost(Integer.parseInt(noneTradePostNo)));
		return "service_trade.page_detail_share_post";
	}
	
	/**
	 * 나눔 게시판 글쓰기
	 * @param tradePostVO
	 * @return 나눔 게시판 List
	 * @author rws
	 */
	@RequestMapping("shareWrite.do")
	public String shareWrite(SharePostVO sharePostVO) {
		sharePostService.addSharePost(sharePostVO);
		return "redirect:detail_share_post.do?noneTradePostNo="+sharePostVO.getNoneTradePostNo();
	}
	
	@RequestMapping("update_share_post.do")
	public String updateSharePostView(String noneTradePostNo, Model model) {
		model.addAttribute("pvo", sharePostService.updateSharePostView(Integer.parseInt(noneTradePostNo)));
		return "service_trade.page_update_share_post";
	}
	
	@RequestMapping("/updateSharePost.do")
	public String updateSharePost(SharePostVO sharePostVO) {
		sharePostService.updateSharePost(sharePostVO);
		return "redirect:detail_share_post.do?noneTradePostNo="+sharePostVO.getNoneTradePostNo();
	}
}
