package org.kosta.momsbay.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.momsbay.model.mapper.PickMapper;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.stereotype.Service;
/**
 * 찜 관련 서비스 제공.
 * ex)찜한 물품보기, 게시판에서 찜 갯수 출력
 * 관련Mapper: PickMapper
 * @author Hwang
 */
@Service
public class PickService {
	@Resource
	private PickMapper pickMapper;
	/**
	 * 아이디로 찜목록을 가져오는 메서드.
	 * @param id
	 * @return List<TradePostVO>
	 * @author Jung
	 */
	public List<TradePostVO> findPickListById(String id) {
		return pickMapper.findPickListById(id);
	}
}
