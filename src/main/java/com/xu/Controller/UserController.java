package com.xu.Controller;

import com.xu.Service.UserService;
import com.xu.Util.TokenUtil;
import com.xu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    TokenUtil tokenUtil;

    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,Object> maps){
        String username=(String)maps.get("username");
        String password=(String)maps.get("password");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Time = df.format(new Date());
        System.out.println("======================================");
        System.out.println(Time+"正在请求登录");
        System.out.println("=======================================");
        User user = service.QueryUserByName(username);
        Map<String,Object> Maps=new HashMap<>();
        String token = tokenUtil.getToken(username, "admin");
        Map<String,String> tok=new HashMap<>();

        if(user==null|| !user.getPassword().equals(password)){
            tok.put("token","1");
            Maps.put("message","error");
            Maps.put("data",tok);

        }
        else{
            Maps.put("message","success");
            tok.put("token",token);
            Maps.put("data",tok);
        }


        return Maps;
    }
    @ResponseBody
    @GetMapping("/info")
    public Map getInfo(String token){
        if(token.equals("1")){
            return null;
        }

        Map<String,Object> maps=new HashMap<>();
        Map<String, String> Map = tokenUtil.parseToken(token);
        Map<String,Object> returnmaps=new HashMap<>();
        Map<String,Object> mmp=new HashMap<>();
        String rules=Map.get("userRole");
        String [] Rules={rules,""};
        returnmaps.put("roles",Rules);
        returnmaps.put("name",Map.get("userId"));
        returnmaps.put("introduction","root");
        returnmaps.put("data",maps);
        returnmaps.put("msg","登录成功");
        returnmaps.put("avatar","http://www.baidu.com");
        mmp.put("data",returnmaps);

        return  mmp;

    }


//    @RequestMapping("/QueryByName")
//    public List<Integer> QueryByName(@RequestBody Map<String,Object> map) throws Exception {
//        System.out.println("进入了");
//       String  username= (String)map.get("username");
//        String  password= (String)map.get("password");
//        List<Integer> list=new LinkedList<>();
//        User user = service.QueryUserByName(username,password);
//        Random r = new Random(1);
//        if(user==null || !user.getPassword().equals(password)){
//
//            list.add(0);
//          return list;
//        }
//        else{
//
//            int i = r.nextInt(10000);
//            list.add(i);
//            return list;
//        }
//
//    }

    @RequestMapping("/QueryAllName")
    public List<String> QueryAllUerName(){
        List<String> strings = service.QueryAllUerName();
        return strings;

    }
}
