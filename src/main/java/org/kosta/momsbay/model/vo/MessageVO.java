package org.kosta.momsbay.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 * 
 * @author kim
 * Message 데이터를 담는 객체.
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO extends PostVO{
	private int messageNo;
	private MemberVO receiveMemberVO;
	private boolean status;
	private int sendMessageNo;
	private boolean receiveFlag;
	private String receiveDate;
}
