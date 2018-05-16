package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.BayPostService;
import org.kosta.momsbay.model.service.QnaPostService;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BayPost 처리하는 Controller. 관련 Service: QnaPostService, BayPostService,
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
	@Resource
	private QnaPostService qnaPostService;
	/**
	 * 일반게시판 &  Q&A게시판 클릭시 실행되는 메서드.
	 * @param viewName
	 * @param boardTypeNo
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("{viewName}.do")
	public String showTiles(@PathVariable String viewName, String boardTypeNo, Model model, String pageNo) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		if(boardTypeNo.equals("5")) {
			model.addAttribute("lvo", bayPostService.getBayPostList(pageNo));
		}else if(boardTypeNo.equals("6")){
			model.addAttribute("lvo", qnaPostService.getQnaPostList(pageNo));
		}
		return "bay/" + viewName+ ".tiles";
	}
	@RequestMapping("write.do")
	public String write(BayPostVO bayPostVO) {
		bayPostService.addPost(bayPostVO);
		return "redirect:bulletin_board_list.do";
	}
}
