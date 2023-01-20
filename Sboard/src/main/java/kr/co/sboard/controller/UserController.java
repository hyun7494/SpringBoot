package kr.co.sboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sboard.service.UserService;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Controller
public final class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("user/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("user/register")
	public String register() {
		return "user/register";
	}
	
	// ip정보를 받기 위해 vo, 뒤에 붙인거임
	@PostMapping("user/register")
	public String register(UserVO vo, HttpServletRequest req) {
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		int result = service.insertUser(vo);
		
		return "redirect:/user/login?success="+result;
	}
	
	@GetMapping("user/terms")
	public String terms(Model model) {
		TermsVO vo = service.selectTerms();
		model.addAttribute(vo);
		return "user/terms";
	}
	
	// ajax로 uid 전송 받았으니 String uid
	// jpa로 처리 할거임
	// json으로 받아오니 responseBody
	@ResponseBody
	@GetMapping("user/checkUid")
	public Map<String, Integer> checkUid(String uid) {
		
		int result = service.countUser(uid);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	
	// 별명 중복 확인
	@ResponseBody
	@GetMapping("user/checkNick")
	public Map<String, Integer> checkNick(String nick){

		int result = service.countNick(nick);
		Map<String, Integer>map = new HashMap<>();
		map.put("result", result);
		return map;
	}
	
	// hp 중복 확인
	@ResponseBody
	@GetMapping("user/checkHp")
	public Map<String, Integer> checkHp(String hp){
		int result = service.countHp(hp);
		Map<String, Integer> map = new HashMap<>();
		map.put("result", result);
		return map;
	}

}
