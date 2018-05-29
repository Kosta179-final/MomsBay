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
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String showTiles(@PathVariable String viewName, String boardTypeNo, Model model, String pageNo, String searchWord) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("searchWord", searchWord);
		if(boardTypeNo.equals("5")) {
			model.addAttribute("lvo", bayPostService.getBayPostList(pageNo,boardTypeNo,searchWord));
		}else if(boardTypeNo.equals("6")){
			model.addAttribute("lvo", qnaPostService.getQnaPostList(pageNo,boardTypeNo,searchWord));
		}
		return "bay/" + viewName+ ".tiles";
	}
	/**
	 * 일반게시판 글쓰기 메서드
	 * @param bayPostVO
	 * @author barom
	 */
	@RequestMapping(value="write.do", method=RequestMethod.POST)
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
	public String list(Model model, String pageNo, String boardTypeNo, String searchWord) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("lvo", bayPostService.getBayPostList(pageNo,boardTypeNo,searchWord));
		model.addAttribute("alvo", bayPostService.getAnnounceList(pageNo,boardTypeNo,searchWord));
		return "bay/list_bulletin_post" + ".tiles";
	}
	
	@RequestMapping("list_qna_post.do")
	public String qnaList(Model model, String pageNo, String boardTypeNo, String searchWord) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("lvo", qnaPostService.getQnaPostList(pageNo,boardTypeNo,searchWord));
		model.addAttribute("qlvo", qnaPostService.getAnnounceQnaList(pageNo,boardTypeNo,searchWord));
		return "bay/list_qna_post" + ".tiles";
	}
	
	/**
	 * 일반게시판 글목록 상세보기 메서드
	 * @param bayPostNo
	 * @param model
	 * @author barom
	 */
	@RequestMapping("detail_bay.do")
	public String getPostDetail(int bayPostNo,Model model) {
		bayPostService.updatePostCount(bayPostNo);
		model.addAttribute("pvo", bayPostService.getPostDetail(bayPostNo));
		return "bay/detail_bay_post" + ".tiles";
	}
	/**
	 * 일반게시판 글삭제 메서드
	 * @param bayPostNo
	 * @param pageNo	
	 * @author barom
	 */
	@RequestMapping(value="deletePost.do", method=RequestMethod.POST)
	public String deletePost(String bayPostNo, int boardTypeNo) {
		bayPostService.deletePost(Integer.parseInt(bayPostNo));
		return "redirect:list_bulletin_post.do?boardTypeNo="+boardTypeNo;
	}
	
	@RequestMapping("updatePostView.do")
	public String updatePostView(int boardTypeNo,int bayPostNo,Model model) {
		model.addAttribute("pvo", bayPostService.getPostDetail(bayPostNo));
		return "bay/update_bay_post"+".tiles";
	}
	
	@RequestMapping(value="updatePost.do", method = RequestMethod.POST)
	public String updatePost(BayPostVO bayPostVO) {
		bayPostService.updatePost(bayPostVO);
		return "redirect:getPostDetailNoHit.do?bayPostNo="+bayPostVO.getBayPostNo();
	}
	
	@RequestMapping("getPostDetailNoHit.do")
	public String getPostDetailNoHit(int bayPostNo, Model model) {
		model.addAttribute("pvo", bayPostService.getPostDetailNohit(bayPostNo));
		return "bay/detail_bay_post" + ".tiles";
	}
	/**
	 * Q&A 게시판 글목록 상세보기 메서드
	 * @param bayPostNoa
	 * @param model
	 * @author sam
	 */
	@RequestMapping("detail_qna_post.do")
	   public String getQnaDetail(int bayPostNo,Model model) {
	      qnaPostService.updateQnaCount(bayPostNo);
	      model.addAttribute("qvo", qnaPostService.getQnaDetail(bayPostNo));
	      return "bay/detail_qna_post" + ".tiles";
	   }
	/**
	 * Q&A 게시판 조회수 증가하지않는 메서드
	 * @param bayPostNo
	 * @param model
	 * @author sam
	 */
	  @RequestMapping("getQnaDetailNoHit.do")
	   public String getQnaDetailNoHit(int bayPostNo,Model model) {
	      model.addAttribute("qvo", qnaPostService.getQnaDetailNoHit(bayPostNo));
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
	public String deleteQnaPost(String bayPostNo, String boardTypeNo) {
		qnaPostService.deleteQnaPost(Integer.parseInt(bayPostNo));
		return "redirect:list_qna_post.do?boardTypeNo="+boardTypeNo;
	}
	/**
	 * Q&A 게시판 수정 메서드
	 * @param qnaPostVO
	 * @author sam
	 */
	   @RequestMapping("updateQnaPost.do")
	   public String updateQnaPost(QnaPostVO qnaPostVO) {
	      qnaPostService.updateQnaPost(qnaPostVO);
	      return "redirect:getQnaDetailNoHit.do?bayPostNo="+qnaPostVO.getBayPostNo();
	   }
	/**
	 * Q&A 게시판 수정폼제공 메서드
	 * @param model
	 * @param bayPostNo
	 * @author sam
	 */
	@RequestMapping("updateQnaPostView.do")
	public String updateQnaPostView(Model model,int bayPostNo) {
		model.addAttribute("qvo", qnaPostService.getQnaDetail(bayPostNo));
		return "bay/update_qna_post" + ".tiles";
	}
}
