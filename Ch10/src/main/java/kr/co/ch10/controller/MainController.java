package kr.co.ch10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = {"/", "/index"})
	public String index() {
		
		logger.trace("trace로그...");
		logger.debug("debug로그...");
		logger.info("info로그...");
		logger.warn("warn로그...");
		logger.error("error로그...");
		
		return "/index";
	}
}
