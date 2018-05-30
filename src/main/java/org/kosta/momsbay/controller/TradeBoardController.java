package org.kosta.momsbay.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.momsbay.model.service.CommentService;
import org.kosta.momsbay.model.service.HistoryService;
import org.kosta.momsbay.model.service.MemberPickService;
import org.kosta.momsbay.model.service.PointService;
import org.kosta.momsbay.model.service.SharePostService;
import org.kosta.momsbay.model.service.TradePostService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.SharePostVO;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * TradePost 처리하는 Controller. 관련Service: TradeService, BayPostService,
 * TradePostService
 * 
 * @author Hwang
 *
 */
@RequestMapping("/trade")
@Controller
public class TradeBoardController {
	private String uploadPath = "C:/java-kosta/framework-workspace2/resources/upload/postImg/";
	@Resource
	private CommentService commentService;
	@Resource
	private TradePostService tradePostService;
	@Resource
	private SharePostService sharePostService;
	@Resource
	private HistoryService historyService;
	@Resource
	private PointService pointService;
	@Resource
	private MemberPickService memberPickService;
	
	/**
	 * 중고거래 게시판 클릭시 실행되는 메서드.
	 * 
	 * @param viewName
	 *            righ
	 * @param boardTypeNo
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("{viewName}.do")
	public String showTiles(@PathVariable String viewName, String categoryNo, String boardTypeNo, String searchWord,
			String pageNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("searchWord", searchWord);
		if (boardTypeNo.equals("1") || boardTypeNo.equals("2")) {
			model.addAttribute("listVO",
					tradePostService.getTradePostList(pageNo, boardTypeNo, categoryNo, searchWord));
			return "service_trade" + ".page_" + viewName;
		} else {
			model.addAttribute("svo", sharePostService.getSharePostList(pageNo, boardTypeNo, categoryNo, searchWord));
			return "service_trade" + ".page_" + viewName;
		}
	}

	/**
	 * 게시판 종류를 클릭했을때 실행되는 메서드.
	 * 
	 * @param categoryNo
	 * @param boardTypeNo
	 * @param pageNo
	 * @param model
	 * @return list_trade_post.jsp
	 */
	@RequestMapping("/list_trade_post.do")
	public String listTradePostTiles(String categoryNo, String boardTypeNo, String searchWord, String pageNo,
			Model model,HttpServletRequest request) {
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("listVO", tradePostService.getTradePostList(pageNo, boardTypeNo, searchWord, categoryNo));
		HttpSession session = request.getSession(false);
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		if(memberVO!=null) {
			model.addAttribute("pickList",memberPickService.findAllPickListById(memberVO.getId()));
		}
		return "service_trade.page_list_trade_post";
	}

	/**
	 * 거래게시판의 삽니다 글쓰기 양식페이지로 이동되는 메서드.
	 * 
	 * @param boardTypeNo
	 * @param categoryNo
	 * @param model
	 * @return add_trade_post.jsp
	 */
	@RequestMapping("/add_trade_post.do")
	public String addTradePostView(String boardTypeNo, String categoryNo, Model model) {
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("categoryNo", categoryNo);
		return "service_trade.page_add_trade_post";
	}

	/**
	 * 글쓰기form에서 submit할때 실행되는 메서드.
	 * 
	 * @param tradePostVO
	 * @param model
	 * @return
	 */
	@Transactional
	@RequestMapping(value = "/addTradePost.do", method = RequestMethod.POST)
	public String addTradePost(TradePostVO tradePostVO, Model model, HttpSession session) {
		/*model.addAttribute("boardTypeNo", tradePostVO.getBoardTypeNo());
		model.addAttribute("categoryNo", tradePostVO.getCategoryNo());*/
		tradePostService.addTradePost(tradePostVO);
	
		MultipartFile multifile = tradePostVO.getFile();
		if (multifile.getOriginalFilename().length()<1) {
			/* 사진업로드를 하지 않은경우 게시물만 올라간다.*/
			tradePostService.addTradePostPhoto("noPhoto", tradePostVO.getTradePostNo());
			return "redirect:detail_trade_post.do?tradePostNo="+tradePostVO.getTradePostNo();
		} else {
			String savedName = "";
			try {
				UUID uid = UUID.randomUUID();
				savedName = uid.toString().substring(0, 5) + "_" + multifile.getOriginalFilename();
				File target = new File(uploadPath, savedName);
				FileCopyUtils.copy(multifile.getBytes(), target);
				tradePostService.addTradePostPhoto(savedName, tradePostVO.getTradePostNo());
			} catch (IOException e) {
				return "redirect:upload_fail.do";
			}
		}
		return "redirect:detail_trade_post.do?tradePostNo="+tradePostVO.getTradePostNo();
	}

	/**
	 * 해당 게시글을 삭제하는 메서드.
	 * 
	 * @param tradePostNo
	 * @return
	 */
	@RequestMapping(value = "/deleteTradePost.do", method = RequestMethod.POST)
	public String deleteTradePost(String tradePostNo) {
		TradePostVO tradePostVO = tradePostService.deleteTradePost(Integer.parseInt(tradePostNo));
		return "redirect:list_trade_post.do?boardTypeNo=" + tradePostVO.getBoardTypeNo() + "&categoryNo="
				+ tradePostVO.getCategoryNo() + "";
	}

	/**
	 * 거래게시판의 삽니다 글수정 양식페이지로 이동되는 메서드.
	 * 
	 * @return update_trade_post.jsp
	 * @author Jung
	 */
	@RequestMapping(value = "/updateTradePostView.do", method = RequestMethod.POST)
	public String updateTradePostView(String tradePostNo, Model model) {
		TradePostVO tradePostVO = tradePostService.findTradePostByTradePostNo(Integer.parseInt(tradePostNo));
		model.addAttribute("tradePostVO", tradePostVO);
		model.addAttribute("boardTypeNo", tradePostVO.getBoardTypeNo());
		model.addAttribute("categoryNo", tradePostVO.getCategoryNo());
		/* 업로드 한 이미지 불러오기 */
		model.addAttribute("imgAddress", tradePostService.findTradePostImgByPostNo(tradePostVO.getTradePostNo()));
		return "service_trade.page_update_trade_post";
	}

	/**
	 * 글수정form에서 submit할때 실행되는 메서드.
	 * 
	 * @return
	 * @author Jung
	 */
	@RequestMapping(value = "/updateTradePost.do", method = RequestMethod.POST)
	public String updateTradePost(TradePostVO tradePostVO, Model model, HttpSession session) {
		model.addAttribute(tradePostService.updateTradePost(tradePostVO));
		
		/*
		 * 상황1. 기존 사진이 없는데 계속 업로드를 안한다 ->아무것도 실행하지 않는다.
		 * 상황2. 사진이 있건 없던 다른사진으로 재업로드 ->update
		 * 상황3. 기존 사진을 없앤다 ->update no photo (이건 버전2에서 할께여.. 시간이1도없음)
		 */
		MultipartFile multifile = tradePostVO.getFile();
		if (multifile.getOriginalFilename().length()<1) {
			/*
			 * 상황1
			 */
			return "redirect:detail_trade_post.do?tradePostNo=" + tradePostVO.getTradePostNo() + "";
		} else {
			/*
			 * 상황2
			 */
			String savedName = "";
			try {
				UUID uid = UUID.randomUUID();
				savedName = uid.toString().substring(0, 5) + "_" + multifile.getOriginalFilename();
				File target = new File(uploadPath, savedName);
				FileCopyUtils.copy(multifile.getBytes(), target);
				tradePostService.updateTradePostPhoto(savedName, tradePostVO.getTradePostNo());
			} catch (IOException e) {
				return "redirect:upload_fail.do";
			}
		}
		return "redirect:detail_trade_post.do?tradePostNo=" + tradePostVO.getTradePostNo() + "";
	}

	/**
	 * 클릭한 번호에 해당하는 상품에 대한 상세정보를 보여준다.
	 * 
	 * @param tradePostNo
	 * @param model
	 * @return detail_trade_post.jsp
	 * @author Jung
	 */
	@RequestMapping("detail_trade_post.do")
	public String detailTradePost(String pageNo, String tradePostNo, Model model) {
		TradePostVO tradePostVO = tradePostService.findTradePostByTradePostNo(Integer.parseInt(tradePostNo));
		model.addAttribute("tradePostVO", tradePostVO);
		model.addAttribute("boardTypeNo", tradePostVO.getBoardTypeNo());
		model.addAttribute("categoryNo", tradePostVO.getCategoryNo());
		model.addAttribute("pageNo", pageNo);
		if(tradePostVO.getTradeId()!=null) {
			model.addAttribute("historyStatus",historyService.findTradeStatusByIdAndTradePostNo(tradePostVO));
		}
		/* 업로드 한 이미지 불러오기 */
		model.addAttribute("imgAddress", tradePostService.findTradePostImgByPostNo(tradePostVO.getTradePostNo()));
		return "service_trade.page_detail_trade_post";
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 나눔게시판 상세보기 메서드
	 * 
	 * @return service_trade.page_detail_share_post
	 * @author rws
	 */
	@RequestMapping("detail_share_post.do")
	public String findDetailSharePost(String pageNo, String noneTradePostNo, Model model) {
		SharePostVO sharePostVO = sharePostService.findDetailSharePost(Integer.parseInt(noneTradePostNo));
		model.addAttribute("pvo", sharePostVO);
		model.addAttribute("boardTypeNo", sharePostVO.getBoardTypeNo());
		model.addAttribute("categoryNo", sharePostVO.getCategoryNo());
		model.addAttribute("pageNo", pageNo);
		/*
		 * 업로드 한 이미지 불러오기
		 */
		model.addAttribute("imgAddress", sharePostService.findSharePostImgByPostNo(sharePostVO.getNoneTradePostNo()));
		/*
		 * 카테고리명 불러오기
		 */
		model.addAttribute("category", sharePostService.findCategory(sharePostVO.getCategoryNo()));
		return "service_trade.page_detail_share_post";
	}

	/**
	 * 나눔 게시판 글쓰기
	 * 
	 * @param tradePostVO
	 * @return detail_share_post.jsp
	 * @author rws
	 */

	@Transactional
	@RequestMapping(value = "shareWrite.do", method = RequestMethod.POST)
	public String shareWrite(@ModelAttribute("sharePostVO") SharePostVO sharePostVO, Model model, HttpSession session) {
		model.addAttribute("boardTypeNo", sharePostVO.getBoardTypeNo());
		model.addAttribute("categoryNo", sharePostVO.getCategoryNo());
		sharePostService.addSharePost(sharePostVO);
		/*
		 * 여기서 부터 파일 업로드 코드
		 */
		MultipartFile multifile = sharePostVO.getFile();
		if (multifile.getOriginalFilename().length()<1) {
			/*
			 * 사진업로드를 하지 않은경우 게시물만 올라간다.
			 */
			sharePostService.addSharePostPhoto("noPhoto", sharePostVO.getNoneTradePostNo());
			return "redirect:detail_share_post.do?noneTradePostNo=" + sharePostVO.getNoneTradePostNo() + "";
		} else {
			String savedName = "";
			try {
				UUID uid = UUID.randomUUID();
				savedName = uid.toString().substring(0, 5) + "_" + multifile.getOriginalFilename();
				File target = new File(uploadPath, savedName);
				FileCopyUtils.copy(multifile.getBytes(), target);
				sharePostService.addSharePostPhoto(savedName, sharePostVO.getNoneTradePostNo());
			} catch (IOException e) {
				return "redirect:upload_fail.do";
			}
			return "redirect:detail_share_post.do?noneTradePostNo=" + sharePostVO.getNoneTradePostNo() + "";
		}
	}

	/**
	 * 나눔 게시판 게시글 수정 페이지로 이동하는 메서드.
	 * 
	 * @param noneTradePostNo
	 * @param model
	 * @return update_share_post.jsp
	 * @author rws
	 */
	@RequestMapping("/update_share_post.do")
	public String updateSharePostView(String noneTradePostNo, Model model) {
		SharePostVO sharePostVO = sharePostService.updateSharePostView(Integer.parseInt(noneTradePostNo));
		model.addAttribute("pvo", sharePostVO);
		model.addAttribute("boardTypeNo", sharePostVO.getBoardTypeNo());
		model.addAttribute("categoryNo", sharePostVO.getCategoryNo());
		model.addAttribute("imgAddress", sharePostService.findSharePostImgByPostNo(sharePostVO.getNoneTradePostNo()));
		return "service_trade.page_update_share_post";
	}

	/**
	 * 나눔 게시판 게시글 수정 submit 메서드
	 * 
	 * @param sharePostVO
	 * @return
	 * @author rws
	 */
	@RequestMapping(value = "/updateSharePost.do", method = RequestMethod.POST)
	public String updateSharePost(SharePostVO sharePostVO, HttpSession session) {
		sharePostService.updateSharePost(sharePostVO);
		/*
		 * 상황1. 기존 사진이 없는데 계속 업로드를 안한다 ->아무것도 실행하지 않는다.
		 * 상황2. 사진이 있건 없던 다른사진으로 재업로드 ->update
		 * 상황3. 기존 사진을 없앤다 ->update no photo (이건 버전2에서 할께여.. 시간이1도없음)
		 */
		MultipartFile multifile = sharePostVO.getFile();
		if (multifile.getOriginalFilename().length()<1) {
			/*
			 * 상황1
			 */
			return "redirect:detail_share_post.do?noneTradePostNo=" + sharePostVO.getNoneTradePostNo();
		} else {
			/*
			 * 상황2
			 */
			String savedName = "";
			try {
				UUID uid = UUID.randomUUID();
				savedName = uid.toString().substring(0, 5) + "_" + multifile.getOriginalFilename();
				File target = new File(uploadPath, savedName);
				FileCopyUtils.copy(multifile.getBytes(), target);
				sharePostService.updateSharePostPhoto(savedName, sharePostVO.getNoneTradePostNo());
			} catch (IOException e) {
				return "redirect:upload_fail.do";
			}
		}
		return "redirect:detail_share_post.do?noneTradePostNo=" + sharePostVO.getNoneTradePostNo();
	}

	/**
	 * 나눔 게시판 게시글 삭제 메서드
	 * 
	 * @param sharePostVO
	 * @return
	 * @author rws
	 */
	@RequestMapping(value="/deleteSharePost.do",method=RequestMethod.POST)
	public String deleteSharePost(String noneTradePostNo) {
		SharePostVO sharePostVO = sharePostService.deleteSharePost(Integer.parseInt(noneTradePostNo));
		return "redirect:list_share_post.do?boardTypeNo=" + sharePostVO.getBoardTypeNo() + "&categoryNo="
				+ sharePostVO.getCategoryNo() + "";
	}

	/**
	 * 나눔 게시판 종류를 클릭했을때 실행되는 메서드
	 * 
	 * @param categoryNo
	 * @param boardTypeNo
	 * @param pageNo
	 * @param model
	 * @return list_share_post.jsp
	 * @author rws
	 */
	@RequestMapping("/list_share_post.do")
	public String listNoneTradePostTiles(String pageNo, String boardTypeNo, String categoryNo, String searchWord,
			Model model) {
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("boardTypeNo", boardTypeNo);
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("svo", sharePostService.getSharePostList(pageNo, boardTypeNo, categoryNo, searchWord));
		return "service_trade.page_list_share_post";
	}

	/**
	 * 나눔 게시판 상세페이지 내에서 거래상태 변경 메서드
	 * 
	 * @param noneTradePostNo
	 * @return detail_share_post.jsp
	 * @author rws
	 */
	@RequestMapping("/updateSharePostByStatus.do")
	public String updateSharePostByStatus(String noneTradePostNo) {
		SharePostVO sharePostVO = sharePostService.updateSharePostByStatus(Integer.parseInt(noneTradePostNo));
		return "redirect:detail_share_post.do?noneTradePostNo=" + sharePostVO.getNoneTradePostNo();
	}
	
	/**
	 * 구매 신청시 거래 신청 페이지로 이동하는 메서드.
	 * @param tradePostNo
	 * @param model
	 * @return apply_trade_view.jsp
	 * @author Jung
	 */
	@RequestMapping("/applyBuyView.do")
	public String applyTradeView(String tradePostNo, Model model) {
		model.addAttribute("tradePostVO",tradePostService.findTradePostByTradePostNo(Integer.parseInt(tradePostNo)));
		return "service_trade.page_apply_buy_view";
	}
	
	/**
	 * 판매 신청시 거래 신청 페이지로 이동하는 메서드.
	 * @param tradePostNo
	 * @param model
	 * @return apply_trade_view.jsp
	 * @author Jung
	 */
	@RequestMapping("/applySellView.do")
	public String applySellView(String tradePostNo, Model model) {
		TradePostVO tradePostVO = tradePostService.findTradePostByTradePostNo(Integer.parseInt(tradePostNo));
		model.addAttribute("tradePostNo", tradePostVO.getTradePostNo());
		model.addAttribute("boardTypeNo", tradePostVO.getBoardTypeNo());
		model.addAttribute("categoryNo", tradePostVO.getCategoryNo());
		return "service_trade.page_apply_sell_view";
	}
	
}







