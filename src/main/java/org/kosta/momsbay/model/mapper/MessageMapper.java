package org.kosta.momsbay.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.momsbay.model.vo.MessageVO;
import org.kosta.momsbay.model.vo.PostVO;

/**
 * 쪽지 서비스 DB연동 Mapper.
 * @author 개발제발
 */
@Mapper
public interface MessageMapper {
	public void addReceiveMessage(MessageVO messageVO);
	public void addSendMessage(MessageVO messageVO);
	public List<PostVO> getReceiveMessageList(Map map);
	public int getTotalReceiveMessageCount(Map map);
	public List<PostVO> getSendMessageList(Map map);
	public int getTotalSendMessageCount(Map map);
	public List<PostVO> getTotalMessageList(Map map);
	public MessageVO detailMessage(Map map);
	public void updateReceiveFlag(int sendMessageNo);
	public void updateStatus(int messageNo);
	public void deleteMessage(Map<String, Object> map);
}
