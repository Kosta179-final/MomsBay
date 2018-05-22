package org.kosta.momsbay.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * 찜 관련 기능 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface PhotoUploadMapper {

	void insertSharePostPhoto(Map<String, Object> map);

	String findSharePostImgByPostNo(int noneTradePostNo);

	void updateSharePostPhoto(Map<String, Object> map);

	void insertTradePostPhoto(Map<String, Object> map);
	
	String findTradePostImgByPostNo(int TradePostNo);

	void updateTradePostPhoto(Map<String, Object> map);
	
}
