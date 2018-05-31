package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.common.ListVO;
import org.kosta.momsbay.model.common.PagingBean;
import org.kosta.momsbay.model.mapper.PhotoUploadMapper;
import org.kosta.momsbay.model.mapper.TradePostMapper;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.stereotype.Service;

/**
 * 교환게시판 관련 비즈니스로직 서비스.
 * 관련Mapper: TradePostMapper
 * @author Ryu
 */
@Service
public class TradePostService {
	@Resource
	private TradePostMapper tradePostMapper;
	@Resource
	private PhotoUploadMapper photoUploadMapper;
	
	/**
	 * 거래게시판의 목록을 출력해주는 메서드.
	 * @param pageNo
	 * @return ListVO
	 * @author Jung
	 */
	public ListVO getTradePostList(String pageNo,String boardTypeNo, String categoryNo/*, String searchWord*/) {
		PagingBean pagingBean=null;
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Map<String,Object> map = new HashMap();
		map.put("pageNo", pageNo==null ? null : pageNo);
		map.put("board_type_no", Integer.parseInt(boardTypeNo));
		map.put("category_no", categoryNo == null ? null : Integer.parseInt(categoryNo));
		/*map.put("searchWord", searchWord);*/
		int totalCount=tradePostMapper.getTotalTradePostCount(map);
		if(pageNo==null || pageNo=="") {
			pagingBean=new PagingBean(totalCount);
			pagingBean.setPostCountPerPage(9);
		}
		else {
			pagingBean=new PagingBean(totalCount,Integer.parseInt(pageNo));
			pagingBean.setPostCountPerPage(9);
		}
		map.put("pagingBean", pagingBean);
		return new ListVO(tradePostMapper.getTradePostList(map),pagingBean);
	}

	/**
	 * tradePostNo와 일치하는 TradePostVO를 반환해주는 메서드
	 * @param tradePostNo
	 * @return TradePostVO
	 */
	public TradePostVO findTradePostByTradePostNo(int tradePostNo) {
		return tradePostMapper.findTradePostByTradePostNo(tradePostNo);
	}

	/**
	 * 게시판에 글을쓰고 자신이 쓴 글을 리턴해주는 메서드.
	 * @param tradePostVO
	 * @return TradePostVO
	 * @author Jung
	 */
	public TradePostVO addTradePost(TradePostVO tradePostVO) {
		tradePostMapper.addTradePost(tradePostVO);
		return tradePostMapper.findTradePostByTradePostNo(tradePostVO.getTradePostNo());
	}

	/**
	 * 해당 게시글을 삭제해주는 메서드
	 * @param tradePostNo
	 * @return TradePostVO
	 * @author Jung
	 */
	public TradePostVO deleteTradePost(int tradePostNo) {
		tradePostMapper.deleteTradePost(tradePostNo);
		return tradePostMapper.findTradePostByTradePostNo(tradePostNo);
	}
	
	/**
	 * 해당 게시물을 업데이트하는 메서드.
	 * @param tradePostNo
	 * @return TradePostVO
	 * @author Jung
	 */
	public TradePostVO updateTradePost(TradePostVO tradePostVO) {
		tradePostMapper.updateTradePost(tradePostVO);
		return tradePostMapper.findTradePostByTradePostNo(tradePostVO.getTradePostNo());
	}

	/**
	 * 거래게시판 글쓰기에서 이미지추가하는 메서드
	 * @param path
	 * @param tradePostNo
	 * @author hwang
	 */
	public void addTradePostPhoto(String path, int tradePostNo) {
		Map<String, Object> map= new HashMap<>();
		map.put("path",path);
		map.put("postNo", tradePostNo);
		photoUploadMapper.insertTradePostPhoto(map);
	}

	/**
	 * 게시물 번호에 해당하는 사진경로를 찾는다.
	 * @param tradePostNo
	 * @return imgAddress
	 * @author Hwang
	 */
	public String findTradePostImgByPostNo(int tradePostNo) {
		String imgAddress=photoUploadMapper.findTradePostImgByPostNo(tradePostNo);
		return imgAddress;
	}

	/**
	 * 게시물 번호에 해당하는 게시글의 사진을 수정.
	 * @param savedName
	 * @param tradePostNo
	 * @author Hwang
	 */
	public void updateTradePostPhoto(String savedName, int tradePostNo) {
		Map<String, Object> map= new HashMap<>();
		map.put("savedName",savedName);
		map.put("postNo", tradePostNo);
		photoUploadMapper.updateTradePostPhoto(map);
	}
	
	
	/**
	 * 거래 신청 시 게시물의 거래자에 id를 업데이트 하는 메서드.
	 * @param id
	 * @author Jung
	 */
	public void updateTradeId(TradePostVO tradePostVO) {
		tradePostMapper.updateTradeId(tradePostVO);
	}
	
	/**
	 * 거래 취소 시 게시물의 거래자에 id를 NULL로 업데이트 하는 메서드.
	 * @param id
	 * @author Jung
	 */
	public void deleteTradeId(int tradePostNo) {
		tradePostMapper.deleteTradeId(tradePostNo);
	}
	
	/**
	 * 게시물의 가격을 조회하는 메서드
	 * @param tradePostNo
	 * @return price
	 * @author Jung
	 */
	public int findPirceByTradePostNo(int tradePostNo) {
		return tradePostMapper.findPirceByTradePostNo(tradePostNo);
	}
	
	/**
	 * 삽니다 게시판 판매 신청시 tradeId와 suggestContent를 업데이트.
	 * @param tradePostVO
	 * @author Jung
	 */
	public void updateTradeIdAndSuggestContent(TradePostVO tradePostVO) {
		tradePostMapper.updateTradeIdAndSuggestContent(tradePostVO);
	}
	
	/**
	 * 삽니다 팝니다 게시글 홈화면에 최신순으로 3개 등록
	 * @return List
	 * @author rws
	 */
	public ListVO getMainTradePostList() {
		return new ListVO(tradePostMapper.getMainTradePostList(),null);
	}
}
