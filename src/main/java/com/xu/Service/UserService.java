package com.xu.Service;

import com.xu.Util.TokenUtil;
import com.xu.mapper.usermapper;
import com.xu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    usermapper mapper;
    @Autowired
    TokenUtil tokenUtil;
    public User QueryUserByName(String name){

        User user = mapper.QueryUserByName(name);
        return user;


    }

public List<String> QueryAllUerName(){
    List<String> strings = mapper.QueryAllUerName();

    return strings;
}
}
