package org.kosta.momsbay.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.MemberVO;
/**
 * 평점 기능 DB연동 Mapper.
 * @author 개발제발
 */
@Mapper
public interface RatingMapper {
	public void createRating(String id);
	
	public void updateRating(MemberVO memberVO);
}
