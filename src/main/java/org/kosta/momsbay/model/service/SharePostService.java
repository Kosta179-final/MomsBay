package org.kosta.momsbay.model.service;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.SharePostMapper;
import org.kosta.momsbay.model.vo.SharePostVO;
import org.springframework.stereotype.Service;

/**
 * 교환게시판 관련 비즈니스로직 서비스.
 * 관련Mapper: SharePostMapper
 * @author Ryu
 */
@Service
public class SharePostService {
	
	@Resource
	private SharePostMapper sharePostMapper;
	
	public void addSharePost(SharePostVO sharePostVO) {
		sharePostMapper.addSharePost(sharePostVO);
	}
}
