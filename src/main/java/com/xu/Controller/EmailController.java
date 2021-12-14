package com.xu.Controller;

import com.xu.Service.EmailService;
import com.xu.pojo.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Email")
public class EmailController {
    @Autowired
    EmailService service;

    @RequestMapping("/Sub/{name}/{email}/{content}")
    public Map<String,Object> mapsubemail(@PathVariable("name")String name, @PathVariable("email") String email, @PathVariable("content")String content) throws MessagingException {
        Email email1=new Email();
        System.out.println("========================================");
        System.out.println("正在发送邮件");
        System.out.println("邮件的内容为: 姓名"+name);
        System.out.println("email为"+email);
        System.out.println("内容为"+content);
        System.out.println("=========================================");
        email1.setName(name);
        email1.setTheEmail(email);
        email1.setContent(content);
Map<String,Object> map=new HashMap<>();
       int i = service.sendMessage(email1);
       map.put("status",i);

       return map;
    }
}
