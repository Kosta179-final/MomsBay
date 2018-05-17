package org.kosta.momsbay.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kosta.momsbay.model.exception.LoginException;
import org.kosta.momsbay.model.mapper.ChildrenMapper;
import org.kosta.momsbay.model.mapper.MemberMapper;
import org.kosta.momsbay.model.vo.ChildrenVO;
import org.kosta.momsbay.model.vo.MemberVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 회원관련 서비스 제공.
 * 관련Mapper: MemberMapper
 * @author Hwang
 */
@Service
public class MemberService {
	@Resource
	private MemberMapper memberMapper;
	@Resource
	private ChildrenMapper childrenMapper;
	
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
		MemberVO memberVO=memberMapper.findMemberById(id);
		if(memberVO==null)
			throw new LoginException("아이디가 존재하지 않습니다");
		else if(password==null||password.equals(memberVO.getPassword())==false)
			throw new LoginException("비밀번호가 다릅니다");
		
		List<ChildrenVO> children = memberMapper.findChildrenByMemberId(id);
		memberVO.setList(children);
		return memberVO;
	}
	
	/**
	 * 아이디가 존재할 경우 false return, 사용가능 할 경우 true return.
	 * 
	 * @param id
	 * @return flag
	 */
	public boolean findMemberExsitById(String id) {
		// TODO Auto-generated method stub
		return memberMapper.findMemberExsitById(id);
	}

	/**
	 * 이메일이 존재할 경우 false return, 사용가능 할 경우 true return.
	 * 
	 * @param email
	 * @return flag
	 */
	public boolean findMemberByEmail(String email) {
		// TODO Auto-generated method stub
		String tempEmail = memberMapper.findMemberByEmail(email);
		if (tempEmail == null) {
			return false;
		} else
			return true;
	}

	/**
	 * member와 children을 Insert. 별도의 처리임으로 트랜젝션 처리. children은 여럿임으로 한명씩 insert 해주되,
	 * 부모 아이디가 별도로 추가되어야 해서 map 형태로 전송.
	 * 
	 * @param member
	 * @param children
	 */
	@Transactional
	public void addMember(MemberVO member, List<ChildrenVO> children) {
		// TODO Auto-generated method stub
		memberMapper.addMember(member);
		if (children.size()>0) {
			for (int i = 0; i < children.size(); i++) {
				Map<String, String> tempMap = new HashMap<String, String>();
				tempMap.put("id", member.getId());
				tempMap.put("gender", children.get(i).getGender());
				tempMap.put("birth", children.get(i).getBirth());
				childrenMapper.addChildren(tempMap);
			}
		}
	}

	public void updateMember(MemberVO member) {
		memberMapper.updateMember(member);
	}

	public boolean findMemberByPasswordAndId(String id, String password) {
		Map<String, String> temp_map = new HashMap<String, String>();
		temp_map.put("id", id);
		temp_map.put("password", password);
		int count = memberMapper.findMemberByPasswordAndId(temp_map);
		if(count==0) {
			return false;
		}else {
			return true;
		}
	}
}
