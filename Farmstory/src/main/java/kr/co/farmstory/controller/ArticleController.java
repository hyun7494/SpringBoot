package kr.co.farmstory.controller;

import kr.co.farmstory.service.ArticleService;
import kr.co.farmstory.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    public ArticleService service;

    @GetMapping("board/list")
    public String list(Model model, String group, String cate, @RequestParam(value="pg", defaultValue = "1") String pg){
        // 페이징 처리
        int currentPage = service.getCurrentPage(pg);
        int start = service.getLimitStart(currentPage);
        int total = service.selectCountTotal(cate);
        int lastPageNum = service.getLastPageNum(total);
        int startPageNum = service.getPageStartNum(total, start);
        int groups[] = service.getPageGroup(currentPage, lastPageNum);

        List<ArticleVO> articles = service.selectArticles(cate, start);

        model.addAttribute("groups", groups);
        model.addAttribute("articles", articles);
        model.addAttribute("group", group);
        model.addAttribute("cate", cate);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("startPageNum", startPageNum);
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
