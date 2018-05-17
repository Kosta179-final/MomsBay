package org.kosta.momsbay.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.MemberPickVO;
/**
 * 찜 목록 추가, 삭제 기능 DB연동 Mapper.
 * @author Jung
 */
@Mapper
public interface MemberPickMapper {
	public void deleteMemberPick(MemberPickVO memberPickVO);

	public void addMemberPick(MemberPickVO memberPickVO);
}
