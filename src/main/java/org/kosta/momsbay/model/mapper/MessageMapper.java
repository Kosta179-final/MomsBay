package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.MessageVO;
import org.kosta.momsbay.model.vo.PostVO;

/**
 * 쪽지 서비스 DB연동 Mapper.
 * @author Hwang
 */
@Mapper
public interface MessageMapper {
	public void addReceiveMessage(MessageVO messageVO);
	public void addSendMessage(MessageVO messageVO);
	public List<PostVO> getReceiveMessageList(Map map);
	public int getTotalMessageCount(String receiveId);

}
