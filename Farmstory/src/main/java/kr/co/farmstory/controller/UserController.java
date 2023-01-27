package kr.co.farmstory.controller;

import kr.co.farmstory.service.UserService;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    public UserService service;

    @GetMapping("user/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("user/register")
    public String register(){
        return "user/register";
    }

    @PostMapping("user/register")
    public String register(UserVO vo, HttpServletRequest req){
        String regip = req.getRemoteAddr();
        vo.setRegip(regip);
        vo.setGrade("3");
        int result = service.insertUser(vo);
        return "redirect:/index";
    }

    @GetMapping("user/terms")
    public String terms(Model model){
        TermsVO vo = service.selectTerms();
        model.addAttribute("vo", vo);
        return "user/terms";
    }
    @ResponseBody
    @GetMapping("user/checkUid")
    // json 형태로 보내야 해서 리턴 타입을 map으로 햇음
    public Map<String,Integer> checkUid(String uid){
        int result = service.countUser(uid);
        Map<String,Integer> map = new HashMap<>();
        map.put("result", result);
        return map;
    }
    @ResponseBody
    @GetMapping("user/checkNick")
    public Map<String,Integer> checkNick(String nick){
        int result = service.countNick(nick);
        Map<String,Integer> map = new HashMap<>();
        map.put("result", result);
        return map;
    }

    @ResponseBody
    @GetMapping("user/checkHp")
    public Map<String,Integer> checkHp(String hp){
        int result = service.checkHp(hp);
        Map<String,Integer> map = new HashMap<>();
        map.put("result", result);
        return map;
    }

}
