package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.CommentService;
import org.kosta.momsbay.model.service.SharePostService;
import org.kosta.momsbay.model.service.TradePostService;
import org.kosta.momsbay.model.vo.SharePostVO;
import org.kosta.momsbay.model.vo.TradePostVO;
//github.com/KostaFinal2ZO/MomsBay.git
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String showTiles(@PathVariable String viewName, String categoryNo,String boardTypeNo,String pageNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("listVO", tradePostService.getTradePostList(pageNo,boardTypeNo,categoryNo));
		return "service_trade" + ".page_" + viewName;
	}
	
	
	@RequestMapping("/list_trade_post.do")
	public String listTradePostTiles(String categoryNo,String boardTypeNo,String pageNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("listVO", tradePostService.getTradePostList(pageNo,boardTypeNo,categoryNo));
		return "service_trade.page_list_trade_post";
	}
	
	
	/**
	 * 거래게시판의 삽니다 글쓰기 양식페이지로 이동되는 메서드.
	 * @param boardTypeNo
	 * @param categoryNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/add_trade_post.do")
	public String addTradePostView(String boardTypeNo, String categoryNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("categoryNo", categoryNo);
		return "service_trade.page_add_trade_post";
	}
	
	/**
	 * 글쓰기form에서 submit할때 실행되는 메서드.
	 * @param tradePostVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/tradeWrite.do",method=RequestMethod.POST)	
	public String tradeWrite(TradePostVO tradePostVO, Model model) {
		model.addAttribute(tradePostService.addTradePost(tradePostVO));
		return "redirect:detail_trade_post.do?tradePostNo="+tradePostVO.getTradePostNo()+"";
	}
	
	
	
	/**
	 * 클릭한 번호에 해당하는 상품에 대한 상세정보를 보여준다.
	 * @param tradePostNo
	 * @param model
	 * @return detail_trade_post.jsp
	 */
	@RequestMapping("detail_trade_post.do")
	public String detailTradePost(String tradePostNo,Model model) {
		model.addAttribute("tradePostVO", tradePostService.findTradePostByTradePostNo
				(Integer.parseInt(tradePostNo)));
		return "service_trade.page_detail_trade_post";
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





