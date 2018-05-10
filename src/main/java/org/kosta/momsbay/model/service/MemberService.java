package org.kosta.momsbay.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.momsbay.model.exception.LoginException;
import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.vo.ChildrenVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.stereotype.Service;
/**
 * 회원관련 서비스 제공.
 * 관련Mapper: MemberMapper
 * @author Hwang
 */
@Service
public class MemberService {
	@Resource
	private MemberMapper memberMapper;
	
	public MemberVO login(String id, String password) throws LoginException {
		MemberVO memberVO=memberMapper.login(id);
		if(memberVO==null)
			throw new LoginException("아이디가 존재하지 않습니다");
		else if(password==null||password.equals(memberVO.getPassword())==false)
			throw new LoginException("비밀번호가 다릅니다");
		
		List<ChildrenVO> children = memberMapper.findChildrenByMemberId(id);
		memberVO.setList(children);
		return memberVO;
	}

}
