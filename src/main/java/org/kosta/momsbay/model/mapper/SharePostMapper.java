package org.kosta.momsbay.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.SharePostVO;
/**
 * 중고물품 게시판 관련 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface SharePostMapper {
	
	public void addSharePost(SharePostVO sharePostVO);
}
