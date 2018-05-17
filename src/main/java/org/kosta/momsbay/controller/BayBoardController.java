package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.BayPostService;
import org.kosta.momsbay.model.service.QnaPostService;
import org.kosta.momsbay.model.vo.BayPostVO;
import org.kosta.momsbay.model.vo.QnaPostVO;
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
	 * 일반게시판 글쓰기 메서드
	 * @param bayPostVO
	 * @author barom
	 */
	@RequestMapping("write.do")
	public String write(BayPostVO bayPostVO) {
		bayPostService.addPost(bayPostVO);
		return "redirect:list_bulletin_post.do?boardTypeNo="+bayPostVO.getBoardTypeNo();
	}
	 /**
	 * @param bayPostNo
	 * @param model
	 * 일반게시판 글목록 상세보기 메서드
	 */
	@RequestMapping("list_bulletin_post.do")
	public String list(Model model, String pageNo, String boardTypeNo) {
		model.addAttribute("lvo", bayPostService.getBayPostList(pageNo));
		model.addAttribute("boardTypeNo", boardTypeNo);
		return "bay/list_bulletin_post" + ".tiles";
	}
	/**
	 * 일반게시판 글목록 상세보기 메서드
	 * @param bayPostNo
	 * @param model
	 * @author barom
	 */
	@RequestMapping("detail_bay.do")
	public String getPostDetail(int bayPostNo,Model model) {
		model.addAttribute("pvo", bayPostService.getPostDetail(bayPostNo));
		return "bay/detail_bay_post" + ".tiles";
	}
	/**
	 * 일반게시판 글삭제 메서드
	 * @param bayPostNo
	 * @param pageNo	
	 * @author barom
	 */
	@RequestMapping("deletePost.do")
	public String deletePost(int bayPostNo, int boardTypeNo) {
		bayPostService.deletePost(bayPostNo);
		return "redirect:list_bulletin_post.do?boardTypeNo="+boardTypeNo;
	}
	
	@RequestMapping("updatePostView.do")
	public String updatePostView(int boardTypeNo,int bayPostNo,Model model) {
		model.addAttribute("pvo", bayPostService.getPostDetail(bayPostNo));
		return "bay/update_bay_post"+".tiles";
	}
	
	@RequestMapping("updatePost.do")
	public String updatePost(BayPostVO bayPostVO) {
		bayPostService.updatePost(bayPostVO);
		//System.out.println(bayPostVO);
		return "redirect:detail_bay.do?bayPostNo="+bayPostVO.getBayPostNo();
	}
	/**
	 * Q&A 게시판 글목록 상세보기 메서드
	 * @param bayPostNoa
	 * @param model
	 * @author sam
	 */
	@RequestMapping("detail_qna_post.do")
	public String getQnaDetail(int bayPostNo,Model model) {
		model.addAttribute("qvo", qnaPostService.getQnaDetail(bayPostNo));
		return "bay/detail_qna_post" + ".tiles";
	}
	/**
	 * Q&A 게시판 글쓰기 메서드
	 * @param bayPostVO
	 * @author sam
	 */
	@RequestMapping("qna_write.do")	
	public String write(QnaPostVO qnaPostVO) {
		qnaPostService.addQnaPost(qnaPostVO);
		return "redirect:list_qna_post.do?boardTypeNo="+qnaPostVO.getBoardTypeNo();
	}
	/**
	 * Q&A 게시판 글삭제 메서드
	 * @param bayPostNo
	 * @param boardTypeNo
	 * @author sam
	 */
	@RequestMapping("deleteQnaPost.do")
	public String deleteQnaPost(int bayPostNo, String boardTypeNo) {
		qnaPostService.deleteQnaPost(bayPostNo);
		return "redirect:list_qna_post.do?boardTypeNo="+boardTypeNo;
	}
	@RequestMapping("updateQnaPost.do")
	public String updateQnaPost(QnaPostVO qnaPostVO ) {
		qnaPostService.updateQnaPost(qnaPostVO);
		return "redirect:detail_qna_post.do?bayPostNo="+qnaPostVO.getBayPostNo();
	}
	@RequestMapping("updateQnaPostView.do")
	public String updateQnaPostView(QnaPostVO qnaPostVO,Model model,int bayPostNo) {
		model.addAttribute("qvo", qnaPostService.getQnaDetail(bayPostNo));
		return "bay/update_qna_post" + ".tiles";
	}
}
