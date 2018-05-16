package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.BayPostService;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * BayPost 처리하는 Controller. 관련Service: TradeService, BayPostService,
 * TradePostService
 * 
 * @author Hwang
 *
 */
@RequestMapping("/bay")
@Controller
public class BayBoardController {
	@Resource
	private BayPostService bayPostService;

	@RequestMapping("{viewName}.do")
	public String showTiles(@PathVariable String viewName, String boardTypeNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		return "bay/" + viewName + ".tiles";
	}

	@RequestMapping("write.do")
	public String write(BayPostVO bayPostVO) {
		System.out.println(bayPostVO);
		bayPostService.addPost(bayPostVO);
		return "redirect:list_bulletin_board.do";
	}

	@RequestMapping("list_bulletin_board.do")
	public String list(Model model, String pageNo, String boardTypeNo) {
		model.addAttribute("lvo", bayPostService.getBayPostList(pageNo));
		model.addAttribute("boardTypeNo", boardTypeNo);
		return "bay/list_bulletin_board" + ".tiles";
	}
	
	@RequestMapping("detail_bay.do")
	public String getPostDetail(int bayPostNo,Model model) {
		model.addAttribute("pvo", bayPostService.getPostDetail(bayPostNo));
		return "bay/detail_bay" + ".tiles";
	}
	
	@RequestMapping("deleteBoard.do")
	public ModelAndView deleteBoard(int bayPostNo,String pageNo) {
		return new ModelAndView("bay/detail_bay","lvo",bayPostService.getBayPostList(pageNo));
	}
	
	/*@RequestMapping("updateBoard.do")
	public ModelAndView updateBoard(BayPostVO bayPostVO,int bayPostNo) {
		bayPostService.updateBoard(bayPostVO);
		return new ModelAndView("bay/update_bay_post","pvo",bayPostService.getPostDetail(bayPostNo));
	}*/
}
