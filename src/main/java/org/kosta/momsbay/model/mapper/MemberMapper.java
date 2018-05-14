package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

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
	public String findMemberById(String id);
	public String findMemberByEmail(String email);
	public void addMember(MemberVO member);
	public void addChildren(Map<String, String> tempMap);
}
