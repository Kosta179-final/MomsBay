package org.kosta.momsbay.model.mapper;

import java.util.HashMap;
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
	public MemberVO findMemberById(String id);
	public List<ChildrenVO> findChildrenByMemberId(String id);
	public boolean findMemberExsitById(String id);
	public String findMemberByEmail(String email);
	public void addMember(MemberVO member);
	public void addChildren(Map<String, String> tempMap);
	public void updateMember(MemberVO member);
	public int findMemberByPasswordAndId(Map<String, String> temp_map);
	public String findNowpointById(String id);
}
