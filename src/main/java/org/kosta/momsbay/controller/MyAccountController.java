package org.kosta.momsbay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 계정관련 작업 처리 Controller.
 * ex)찜목록, 포인트충전, 거래내역 및 포인트 내역출력
 * @author Hwang
 */
@RequestMapping("/myaccount")
@Controller
public class MyAccountController {
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName) {
		return "service_myaccount" + ".page_" + viewName;
	}
}
