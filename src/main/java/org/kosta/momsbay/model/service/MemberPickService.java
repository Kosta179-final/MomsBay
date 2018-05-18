package org.kosta.momsbay.model.service;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.MemberPickMapper;
import org.kosta.momsbay.model.vo.MemberPickVO;
import org.springframework.stereotype.Service;
/**
 * 찜관련 서비스 제공.
 * 관련Mapper: MemberPickMapper
 * @author Hwang
 */
@Service
public class MemberPickService {
	@Resource
	private MemberPickMapper memberPickMapper;
	
	/**
	 * 찜 삭제.
	 * @param memberPickVO
	 * @author Jung
	 */
	public void deleteMemberPick(MemberPickVO memberPickVO) {
		memberPickMapper.deleteMemberPick(memberPickVO);
	}
	
	/**
	 * 찜 추가.
	 * @param memberPickVO
	 * @author Jung
	 */
	public void addMemberPick(MemberPickVO memberPickVO) {
		memberPickMapper.addMemberPick(memberPickVO);
	}
	
}
