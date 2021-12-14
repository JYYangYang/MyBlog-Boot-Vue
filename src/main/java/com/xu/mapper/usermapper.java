package com.xu.mapper;

import com.xu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;

@Component
@Mapper
public interface usermapper {

    public User QueryUserByName(String name);

    public List<String>  QueryAllUerName();
}
