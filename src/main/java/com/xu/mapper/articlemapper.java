package com.xu.mapper;

import com.xu.pojo.Article;
import com.xu.pojo.page;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface articlemapper {

    public List<Article> QueryAll();

    public void add(Map<String,Object> map);
    public Article QueryById(int id);
    public void DeleteById(int id);

    public void updateById(Map<String,Object> map);


    //==============分页=============
    //分页查询操作
    public page selectByPage(int currentPage, int PageSize,
                             HashMap<String,Object> map)throws SQLException;;




    //获得总的文章数量
    public int totalItemNumber();

    //当前页的数据
    public List<Article> selectByPageItem(Map<String,Object> map);

    //==============分页===========


    List<Article> QueryThemes();


    List<Article> QueryByTheme(String themes);
}
