package com.xu.pojo;

import java.util.Date;

public class Article {
    private Integer id;
    private String author;
    private String title;
    private String introduction;
    private String content;
    private Date createtime;
    protected  String themes;

    public Article(Integer id, String author, String title, String introduction, String content, Date createtime, String themes) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.introduction = introduction;
        this.content = content;
        this.createtime = createtime;
        this.themes = themes;
    }

    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", themes='" + themes + '\'' +
                '}';
    }
}
