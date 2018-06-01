package org.kosta.momsbay.model.service;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.RatingMapper;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.stereotype.Service;
/**
 * 평점 관련 Service
 * 관련Mapper: RatingMapper
 * @author Jung
 */
@Service
public class RatingService {
	@Resource
	private RatingMapper ratingMapper;
	
	/**
	 * id에 해당하는 평점테이블을 생성하는 메서드
	 * @param id
	 * @author Jung
	 */
	public void createRating(String id) {
		ratingMapper.createRating(id);
	}
	
	/**
	 * 평점을 업데이트하는 메서드
	 * @param rating
	 * @author Jung
	 */
	public void updateRating(MemberVO memberVO) {
		ratingMapper.updateRating(memberVO);
	}
}
