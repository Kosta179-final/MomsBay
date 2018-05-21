package org.kosta.momsbay.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * 찜 관련 기능 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface PhotoUploadMapper {

	void insertPostPhoto(Map<String, Object> map);

	String findSharePostImgByPostNo(int noneTradePostNo);
	
}
