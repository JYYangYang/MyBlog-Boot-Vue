package com.xu.Controller;

import com.xu.Service.ArticleService;
import com.xu.pojo.Article;
import com.xu.pojo.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Article")
public class ArticleController {
    @Autowired
    ArticleService service;

    @RequestMapping("/QueryAll")
    public List<Article> QueryAll(){
        return service.QueryAll();
    }


        @PostMapping("/AddArticle")
        @ResponseBody
        public int Insert(@RequestBody Map<String,Object> map){
        service.add(map);
        return 1;
    }

    @GetMapping("/QueryById/{id}")
    public Article QueryById(@PathVariable("id") int id){
        Article article = service.QueryById(id);
        return article;
    }

    @GetMapping("/DeleteById/{id}")
    public void DeleteById(@PathVariable("id") int id){

        service.DeleteById(id);
    }
    @RequestMapping("/UpdateById")
    @ResponseBody
    public void UpdateById(@RequestBody Map<String,Object> map){

        service.UpdateById(map);
    }

    @RequestMapping("/QueryAllThemes")
    public List<Article> QueryThemes(){
        Map<String,Object> maps=new HashMap<>();
        List<Article> strings = service.QueryThemes();
        return strings;
    }

    @RequestMapping("/QueryByTheme/{themes}")
    public List<Article> QueryByTheme(@PathVariable("themes") String themes){
        List<Article> articles = service.QueryByTheme(themes);
        return articles;
    }



    @RequestMapping("/GetMes")
    public Map<String,Object> dashboard(){
        Map<String,Object> returnMap=new HashMap<>();
        List<Article> articles = service.QueryAll();
      int ArticleNum= articles.size();
        List<Article> articles1 = service.QueryThemes();
        int ThemeNum=articles1.size();
        returnMap.put("TotolArticle",ArticleNum);
        returnMap.put("ThemeNum",ThemeNum);
        return returnMap;


    }


}
