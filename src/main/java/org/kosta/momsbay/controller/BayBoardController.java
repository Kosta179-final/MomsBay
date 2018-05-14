package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.BayPostService;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String showTiles(@PathVariable String viewName, String type, Model model) {
		model.addAttribute("type", type);
		return "bay/" + viewName + ".tiles";
	}

	@RequestMapping("write.do")
	public String write(BayPostVO bayPostVO) {
		bayPostService.addPost(bayPostVO);
		return "redirect:bulletin_board_list.do";
	}

	@RequestMapping("bulletin_board_list.do")
	public String list(Model model, String pageNo, String type) {
		model.addAttribute("lvo", bayPostService.getBayPostList(pageNo));
		model.addAttribute("type", type);
		return "bay/bulletin_board_list" + ".tiles";
	}
}
