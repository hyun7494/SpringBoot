package kr.co.farmstory.controller;

import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    public ArticleService service;

    @GetMapping("board/list")
    public String list(Model model, String group, String cate){
        List<ArticleVO> articles = service.selectArticles(cate);
        model.addAttribute("group",group);
        model.addAttribute("cate",cate);
        model.addAttribute("articles", articles);
        return "board/list";
    }

    @GetMapping("board/modify")
    public String modify(Model model, String group, String cate){

        model.addAttribute("group",group);
        model.addAttribute("cate",cate);
        return "board/modify";
    }

    @GetMapping("board/view")
    public String view(Model model, String group, String cate, int no){

        model.addAttribute("group",group);
        model.addAttribute("cate",cate);
        ArticleVO article = service.selectArticle(no);

        return "board/view";
    }

    @GetMapping("board/write")
    public String write(Model model,String group, String cate){

        model.addAttribute("group",group);
        model.addAttribute("cate",cate);
        return "board/write";
    }
}
