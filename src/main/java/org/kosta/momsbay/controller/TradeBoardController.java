package org.kosta.momsbay.controller;

import javax.annotation.Resource;

import org.kosta.momsbay.model.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TradePost 처리하는 Controller.
 * 관련Service: TradeService, BayPostService, TradePostService
 * @author Hwang
 *
 */
@RequestMapping("/trade")
@Controller
public class TradeBoardController {
	@Resource
	private CommentService commentService;
	
	@RequestMapping("/{viewName}.do")
	public String showTiles(@PathVariable String viewName) {
		return "service_trade" + ".page_" + viewName;
	}
}
