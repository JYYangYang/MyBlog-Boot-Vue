package com.xu.Service;

import com.xu.pojo.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    JavaMailSenderImpl mailSender;


    public int sendMessage(Email email) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装起来
        MimeMessageHelper Helper = new MimeMessageHelper(mimeMessage, true);

        Helper.setSubject("对个人博客的建议");
        String string="名字:  "+email.getName()+"<br>"+"邮箱:  "+email.getTheEmail()
                +"<br>"+"内容："+email.getContent();
                ;
        Helper.setText(string,true);
        Helper.setFrom("1796988521@qq.com");
        Helper.setTo("1796988521@qq.com");
        System.out.println("========发送邮件中========");
        mailSender.send(mimeMessage);
        return 1;
    }



}
