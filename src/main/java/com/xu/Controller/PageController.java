package com.xu.Controller;

import com.xu.Service.ArticleService;
import com.xu.pojo.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Page")
public class PageController {
    @Autowired
    ArticleService service;
    @RequestMapping("/ToPage/{currentPage}/{pageSize}")
    public Map<String,Object> pagecontroller(@PathVariable("currentPage")Integer currentPage, @PathVariable("pageSize")Integer pageSize,
                                             Model model, HttpServletRequest request) throws SQLException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Time = df.format(new Date());
        System.out.println("======================================");
        System.out.println(Time+"正在分页查询文章");
        System.out.println("======================================");
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        page page = service.selectByPage(currentPage,pageSize,map);
        Map<String,Object> returnmap=new HashMap<>();
        returnmap.put("page",page);
        return returnmap;
    }
}
