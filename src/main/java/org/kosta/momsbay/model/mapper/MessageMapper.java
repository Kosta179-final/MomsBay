package org.kosta.momsbay.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.MessageVO;

/**
 * 쪽지 서비스 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface MessageMapper {
	public void addReceiveMessage(MessageVO messageVO);
	public void addSendMessage(MessageVO messageVO);
}
