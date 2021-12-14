package com.xu.Service;

import com.xu.mapper.articlemapper;
import com.xu.pojo.Article;
import com.xu.pojo.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {
    @Autowired
    articlemapper mapper;

    public List<Article> QueryAll(){
        return mapper.QueryAll();
    }

    public void add(Map<String,Object> map){


        mapper.add(map);
    }


    public Article QueryById(int id){

        Article article = mapper.QueryById(id);
        return article;
    }

    public void DeleteById(int id){
        mapper.DeleteById(id);
    }

    public void UpdateById(Map<String,Object> map){
        mapper.updateById(map);
    }
//===========分页=====================
    public page selectByPage(int currentPage, int pagaSize,
                             Map<String,Object> map)throws SQLException
    {
        page <Article> p=new page<>();
        p.setPageNo(currentPage);
        p.setPageSize(pagaSize);

        p.setTotalItemNumber(totalItemNumber());
        int totalPageNumber=p.getTotalPageNumber();
        p.setTotalPageNumber(totalPageNumber);
        p.setList(selectByPageItem(map));

        return p;
    }


    public int totalItemNumber(){
        return mapper.totalItemNumber();

    }

    public List<Article> selectByPageItem(Map<String,Object> map){
        return mapper.selectByPageItem(map);
    }
    //====================分页============



    public List<Article> QueryThemes(){
        List<Article> strings = mapper.QueryThemes();
        return strings;
    }


    public List<Article> QueryByTheme(String theme){
        List<Article> articles = mapper.QueryByTheme(theme);
        return articles;
    }
}
