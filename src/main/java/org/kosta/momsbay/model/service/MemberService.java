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
	
	/**
	 * 로그인 비즈니스로직.
	 * 1.파라미터의 id로 Member를 검색, 
	 *    존재하지 않을 시에 "아이디 존재하지 않음" 메시지 throw
	 * 2.id가 존재하면 password를 비교
	 *   일치하지 않으면, "비밀번호가 다름" 메시지 throw
	 * 3.두 조건 모두 만족시, 자녀정보를 회원 id로 검색
	 *    MemberVO에 SET하여 Return
	 * @param id
	 * @param password
	 * @return 자녀정보가 포함된 MemberVO
	 * @throws LoginException
	 */
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
