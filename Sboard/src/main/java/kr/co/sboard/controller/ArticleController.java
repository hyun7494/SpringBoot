package kr.co.sboard.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.service.ArticleService;
import kr.co.sboard.vo.ArticleVO;


@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	// 이것도 방식임(security 이용안하고)
	/*
	@GetMapping("list")
	public String list(Principal principal) {
		
		if(principal != null) {
			return "list";
		}else {
			return "redirect:/user/login";
		}
	}
	*/
	
	@GetMapping("/list")
	public String list(Principal principal,Model model) {
		List<ArticleVO> articles = service.selectArticles();
		model.addAttribute("articles", articles);
		return "/list";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
	@GetMapping("/view")
	public String view() {
		return "/view";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(ArticleVO vo, HttpServletRequest req) {
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertArticle(vo);
		return "redirect:/list";
	}
	
}
