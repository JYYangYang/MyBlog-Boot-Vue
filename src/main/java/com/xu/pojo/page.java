package com.xu.pojo;

import java.util.List;

public class page<T>{


    private int pageNo;//当前是第几页


    private List<T> list; //当前显示的图书列表集合


    private int pageSize = 3;//页面的尺寸数


    public long getTotalItemNumber() {
        return totalItemNumber;
    }

    private long totalItemNumber;//总的条目数

    private int totalPageNumber;//总页数


    public page(int pageNo) {
        super();
        this.pageNo = pageNo;
    }


    public int getPageNo() {
        if(pageNo < 0)
            pageNo = 1;

        if(pageNo > getTotalPageNumber()){
            pageNo = getTotalPageNumber();
        }

        return pageNo;
    }

    public page() {
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public  void setTotalPageNumber(int totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }

    public int getTotalPageNumber(){

        totalPageNumber = (int)totalItemNumber / pageSize;

        if(totalItemNumber % pageSize != 0){
            totalPageNumber++;
        }

        return totalPageNumber;
    }

    public void setTotalItemNumber(long totalItemNumber) {
        this.totalItemNumber = totalItemNumber;
    }

    public boolean isHasNext(){
        if(getPageNo() < getTotalPageNumber()){
            return true;
        }

        return false;
    }

    public boolean isHasPrev(){
        if(getPageNo() > 1){
            return true;
        }

        return false;
    }

    public int getPrevPage(){
        if(isHasPrev()){
            return getPageNo() - 1;
        }

        return getPageNo();
    }

    public int getNextPage(){
        if(isHasNext()){
            return getPageNo() + 1;
        }

        return getPageNo();
    }
}
