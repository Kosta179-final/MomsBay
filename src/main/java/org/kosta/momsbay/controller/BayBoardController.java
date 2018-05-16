package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.BayPostService;
import org.kosta.momsbay.model.service.QnaPostService;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * BayPost 처리하는 Controller. 관련 Service: QnaPostService, BayPostService, TradePostService
 * @author Hwang
 */
@RequestMapping("/bay")
@Controller
public class BayBoardController {
	@Resource
	private BayPostService bayPostService;
	@Resource
	private QnaPostService qnaPostService;
	/**
	 * @param viewName
	 * @param boardTypeNo
	 * @param pageNo
	 * @param model
	 * 일반게시판 &  Q&A게시판 클릭시 해당경로 지정 메서드
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
	/**
	 * @param bayPostVO
	 * 일반게시판 글쓰기 메서드
	 */
	@RequestMapping("write.do")
	public String write(BayPostVO bayPostVO) {
		System.out.println(bayPostVO);
		bayPostService.addPost(bayPostVO);
		return "redirect:list_bulletin_post.do";
	}
	/**
	 * @param bayPostNo
	 * @param model
	 * 일반게시판 글목록 상세보기 메서드
	 */
	@RequestMapping("detail_bay.do")
	public String getPostDetail(int bayPostNo,Model model) {
		model.addAttribute("pvo", bayPostService.getPostDetail(bayPostNo));
		return "bay/detail_bay" + ".tiles";
	}
	/**
	 * @param bayPostNo
	 * @param pageNo
	 * 일반게시판 글삭제 메서드
	 */
	@RequestMapping("deleteBoard.do")
	public ModelAndView deleteBoard(int bayPostNo,String pageNo) {
		return new ModelAndView("bay/detail_bay","lvo",bayPostService.getBayPostList(pageNo));
	}
	
	/*@RequestMapping("updateBoard.do")
	public ModelAndView updateBoard(BayPostVO bayPostVO,int bayPostNo) {
		bayPostService.updateBoard(bayPostVO);
		return new ModelAndView("bay/update_bay_post","pvo",bayPostService.getPostDetail(bayPostNo));
	}*/
	/**
	 * @param bayPostNo
	 * @param model
	 * Q&A 게시판 글목록 상세보기 메서드
	 */
	@RequestMapping("detail_qna_post.do")
	public String getQnaDetail(int bayPostNo,Model model) {
		model.addAttribute("qvo", qnaPostService.getQnaDetail(bayPostNo));
		return "bay/detail_qna_post" + ".tiles";
	}
}
