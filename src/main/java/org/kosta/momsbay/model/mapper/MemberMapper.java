package org.kosta.momsbay.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.ChildrenVO;
import org.kosta.momsbay.model.vo.MemberVO;
/**
 * member 관련 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface MemberMapper {
	public MemberVO login(String id);
	public List<ChildrenVO> findChildrenByMemberId(String id);
}
