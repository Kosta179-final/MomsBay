package org.kosta.momsbay.model.aop;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.kosta.momsbay.model.service.MessageService;
import org.kosta.momsbay.model.service.TradePostService;
import org.kosta.momsbay.model.vo.MemberVO;
import org.kosta.momsbay.model.vo.MessageVO;
import org.kosta.momsbay.model.vo.TradePostVO;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MessageAspact {
	@Resource
	private MessageService messageService;
	@Resource
	private TradePostService tradePostService;
	
	@Around("execution(public * org.kosta.momsbay.model.service.HistoryService.addPointChargeHistory(..)) || "
			+ "execution(public * org.kosta.momsbay.model.service.HistoryService.addPointExchangeHistory(..)) || "
			+ "execution(public * org.kosta.momsbay.controller.TradeController.applyTrade(..)) || "
			+ "execution(public * org.kosta.momsbay.controller.TradeController.applySell(..)) || "
			+ "execution(public * org.kosta.momsbay.controller.TradeController.updateDeliveryTradeHistory(..)) || "
			+ "execution(public * org.kosta.momsbay.controller.MemberController.register(..)) || "
			+ "execution(public * org.kosta.momsbay.controller.TradeController.completeTransaction(..))")
	public Object saveReport(ProceedingJoinPoint point) throws Throwable {
		Object retValue = null;
		retValue = point.proceed();
		String mn = point.getSignature().getName();
		Object params[] = point.getArgs();
		
		// messageVO 생성
		MessageVO messageVO = new MessageVO();
		MemberVO receiveMemberVO = new MemberVO();
		MemberVO memberVO = new MemberVO();
		messageVO.setReceiveMemberVO(receiveMemberVO);
		messageVO.setMemberVO(memberVO);
		
		if(mn.equals("register")) {
			memberVO = (MemberVO) params[0];
			messageVO.getReceiveMemberVO().setId(memberVO.getId());
			messageVO.getMemberVO().setId("admin1");
			messageVO.setTitle("관리자 메세지 입니다");
			messageVO.setContent("Momsbay에 오신것을 환영합니다.");
			messageService.addMessage(messageVO);
		} else if(mn.equals("addPointChargeHistory")) {
			String id = (String) params[0];
			int money = (int) params[1];
			messageVO.getReceiveMemberVO().setId(id);
			messageVO.getMemberVO().setId("admin1");
			messageVO.setTitle("관리자 메세지 입니다");
			messageVO.setContent(money+"포인트 충전이 완료되었습니다");
			messageService.addMessage(messageVO);
		} else if(mn.equals("addPointExchangeHistory")) {
			String id = (String) params[0];
			int money = (int) params[1];
			messageVO.getReceiveMemberVO().setId(id);
			messageVO.getMemberVO().setId("admin1");
			messageVO.setTitle("관리자 메세지 입니다");
			messageVO.setContent(money+"포인트 환전이 완료되었습니다");
			messageService.addMessage(messageVO);
		} else if(mn.equals("applyTrade")) {
			TradePostVO tradePostVO = (TradePostVO) params[0];
			if(tradePostVO.getBoardTypeNo() == 2) {
				messageVO.getReceiveMemberVO().setId(tradePostVO.getTradeId());
				messageVO.getMemberVO().setId("admin1");
				messageVO.setTitle("관리자 메세지 입니다");
				messageVO.setContent(tradePostVO.getTradePostNo()+"게시글의 거래가 신청되었습니다");
				messageService.addMessage(messageVO);
			}
			else {
				tradePostVO = tradePostService.findTradePostByTradePostNo(tradePostVO.getTradePostNo());
				messageVO.getReceiveMemberVO().setId(tradePostVO.getTradeId());
				messageVO.getMemberVO().setId("admin1");
				messageVO.setTitle("관리자 메세지 입니다");
				messageVO.setContent(tradePostVO.getTradePostNo()+"게시글의 입금이 완료되었습니다");
				messageService.addMessage(messageVO);
			}
		} else if(mn.equals("applySell")) {
			TradePostVO tradePostVO = (TradePostVO) params[0];
			messageVO.getReceiveMemberVO().setId(tradePostVO.getMemberVO().getId());
			messageVO.getMemberVO().setId("admin1");
			messageVO.setTitle("관리자 메세지 입니다");
			messageVO.setContent(tradePostVO.getTradePostNo()+"게시글의 거래가 신청되었습니다");
			messageService.addMessage(messageVO);
		} else if(mn.equals("updateDeliveryTradeHistory")) {
			String tradePostNo = (String) params[0];
			TradePostVO tradePostVO = tradePostService.findTradePostByTradePostNo(Integer.parseInt(tradePostNo));
			if(tradePostVO.getBoardTypeNo() == 2) {
				messageVO.getReceiveMemberVO().setId(tradePostVO.getTradeId());
				messageVO.getMemberVO().setId("admin1");
				messageVO.setTitle("관리자 메세지 입니다");
				messageVO.setContent(tradePostVO.getTradePostNo()+"게시글의 물품이 배송되었습니다");
				messageService.addMessage(messageVO);
			} else {
				messageVO.getReceiveMemberVO().setId(tradePostVO.getMemberVO().getId());
				messageVO.getMemberVO().setId("admin1");
				messageVO.setTitle("관리자 메세지 입니다");
				messageVO.setContent(tradePostVO.getTradePostNo()+"게시글의 물품이 배송되었습니다");
				messageService.addMessage(messageVO);
			}
		} else if(mn.equals("completeTransaction")) {
			String tradePostNo = (String) params[1];
			TradePostVO tradePostVO = tradePostService.findTradePostByTradePostNo(Integer.parseInt(tradePostNo));
			if(tradePostVO.getBoardTypeNo() == 2) {
				messageVO.getReceiveMemberVO().setId(tradePostVO.getMemberVO().getId());
				messageVO.getMemberVO().setId("admin1");
				messageVO.setTitle("관리자 메세지 입니다");
				messageVO.setContent(tradePostVO.getTradePostNo()+"게시글의 거래가 완료되었습니다");
				messageService.addMessage(messageVO);
			} else {
				messageVO.getReceiveMemberVO().setId(tradePostVO.getTradeId());
				messageVO.getMemberVO().setId("admin1");
				messageVO.setTitle("관리자 메세지 입니다");
				messageVO.setContent(tradePostVO.getTradePostNo()+"게시글의 거래가 완료되었습니다");
				messageService.addMessage(messageVO);
			}
		}
		return retValue;
	}
}
