package org.kosta.momsbay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Home으로 mapping과 PathVariable을 통해 페이지이동을 담당하는 컨트롤러.
 * @author Hwang
 *
 */
@Controller
public class HomeController {
	@RequestMapping("home.do")
	public String home() {
		return "home.tiles";
	}
}
